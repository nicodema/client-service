package com.devsu.clientservice.service;

import java.util.List;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsu.clientservice.exception.ClienteException;
import com.devsu.clientservice.model.Cliente;
import com.devsu.clientservice.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private Queue clienteCreadoQueue;
	
	@Override
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtenerPorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new ClienteException("Cliente no encontrado con id: " + id));
	}

	@Override
	public void crearCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		String mensaje = "Cliente creado: " + cliente.getNombre() +  ", con el id: "+cliente.getId();
		rabbitTemplate.convertAndSend(clienteCreadoQueue.getName(), mensaje);
		System.out.println("Mensaje: " + mensaje);
	}

	@Override
	public void actualizarCliente(Long id, Cliente cliente) {
		cliente.setId(id);
		clienteRepository.save(cliente);
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
