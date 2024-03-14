package com.shop.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

public record ClienteCadastro(
		String nome,
		@NotBlank(message = "CPF não pode ser vazio") @CPF String cpf) {

}
