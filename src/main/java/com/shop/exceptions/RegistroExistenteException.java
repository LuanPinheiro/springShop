package com.shop.exceptions;

public class RegistroExistenteException extends RuntimeException{

	public RegistroExistenteException(String nomeRegistro) {
		super(nomeRegistro + " já existe");
	}
}