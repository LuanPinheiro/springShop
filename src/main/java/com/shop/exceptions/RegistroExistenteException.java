package com.shop.exceptions;

public class RegistroExistenteException extends MessageRuntimeException {

	public RegistroExistenteException(String nomeRegistro) {
		super(nomeRegistro + " já existe");
	}
}