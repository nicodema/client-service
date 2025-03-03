package com.devsu.clientservice.exception;

public class ClienteException extends RuntimeException{
	private static final long serialVersionUID = 7810224569173184766L;

	public ClienteException(String mensaje) {
		super(mensaje);
	}
}
