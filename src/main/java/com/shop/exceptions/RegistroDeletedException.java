package com.shop.exceptions;

public class RegistroDeletedException extends RuntimeException{

	public RegistroDeletedException(String nomeRegistro) {
		super(nomeRegistro + " já apagado");
	}
}