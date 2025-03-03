package com.devsu.clientservice.service;
import java.util.List;

import com.devsu.clientservice.model.Cliente;


public interface ClienteService {
	List<Cliente> listarTodos();
	Cliente obtenerPorId(Long id);
	void crearCliente(Cliente cliente);
	void actualizarCliente(Long id, Cliente cliente);
	void eliminarCliente(Long id);
}
