package com.devsu.clientservice.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devsu.clientservice.model.Cliente;
import com.devsu.clientservice.repository.ClienteRepository;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceImplTest {

	@Mock
	private ClienteRepository clienteRepository;

	@InjectMocks
	private ClienteServiceImpl clienteService;

	@Test
	public void testListarTodos() {
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Jose Lema");

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Mariela Montalvo");

		when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

		List<Cliente> clientes = clienteService.listarTodos();
		assertEquals(2, clientes.size());
		verify(clienteRepository, times(1)).findAll();
	}
	
	@Test
	public void testObtenerPorId() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNombre("Jose Lema");


		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));

		Cliente respuesta = clienteService.obtenerPorId(1L);
		
		assertEquals("Jose Lema", respuesta.getNombre());
		verify(clienteRepository, times(1)).findById(1L);
	}
}
