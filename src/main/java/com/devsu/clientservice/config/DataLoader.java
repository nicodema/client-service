package com.devsu.clientservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devsu.clientservice.model.Cliente;
import com.devsu.clientservice.repository.ClienteRepository;



@Component
public class DataLoader implements CommandLineRunner{
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void run(String... args) throws Exception {
		if(clienteRepository.count() == 0) {
			Cliente cli1 = new Cliente("Jose Lema", "Masculino", 30, "123456789", "Otavalo sn y principal", "098254785", "1234", true);
			Cliente cli2 = new Cliente("Marianela Montalvo", "Femenino", 25, "987654321", "Amazonas y NNUU", "097548965", "5678", true);
		
			clienteRepository.save(cli1);
			clienteRepository.save(cli2);
			
			System.out.println("Clientes predefinidos");
		}else {
			System.out.println("Ya existen Clientes predefinidos");
		}
		
	}
}
