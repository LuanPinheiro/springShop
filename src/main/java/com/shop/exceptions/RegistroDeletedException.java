package com.shop.exceptions;

public class RegistroDeletedException extends MessageRuntimeException {

	public RegistroDeletedException(String nomeRegistro) {
		super(nomeRegistro + " já apagado");
	}
}