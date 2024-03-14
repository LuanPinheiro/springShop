package com.shop.dtos;

import com.shop.models.Cliente;

public record ClienteListar(
		String nome,
		String cpf) {

	public ClienteListar(Cliente cliente) {
		this(cliente.getNome(), cliente.getCpf());
	}
}
