package com.devsu.clientservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CLIENTES")
public class Cliente extends Persona{

	private String contrasena;
	private boolean estado;
	
	public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono, String contrasena, boolean estado) {
		super(nombre, genero, edad, identificacion, direccion, telefono);
		this.contrasena = contrasena;
		this.estado = estado;
	}

}
