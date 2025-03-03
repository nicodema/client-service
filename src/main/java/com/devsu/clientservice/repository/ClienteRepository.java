package com.devsu.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsu.clientservice.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
