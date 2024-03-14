package com.shop.exceptions;

public class RegistroNotFoundException extends RuntimeException {

	public RegistroNotFoundException(String nomeRegistro) {
		super(nomeRegistro + " não encontrado");
	}
}
