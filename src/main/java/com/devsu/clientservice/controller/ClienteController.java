package com.devsu.clientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.clientservice.model.Cliente;
import com.devsu.clientservice.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
		Cliente cl = clienteService.obtenerPorId(id);
		return ResponseEntity.ok(cl);

	}

	@PostMapping
	public void crearCliente(@RequestBody Cliente cliente) {
		clienteService.crearCliente(cliente);
	}

	@PutMapping("/{id}")
	public void actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.actualizarCliente(id, cliente);
	}

	@DeleteMapping("/{id}")
	public void eliminarCliente(@PathVariable Long id) {
		clienteService.eliminarCliente(id);
	}
}
