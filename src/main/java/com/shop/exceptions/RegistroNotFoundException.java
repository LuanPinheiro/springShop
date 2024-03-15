package com.shop.exceptions;

public class RegistroNotFoundException extends MessageRuntimeException {

	public RegistroNotFoundException(String nomeRegistro) {
		super(nomeRegistro + " não encontrado");
	}
}
