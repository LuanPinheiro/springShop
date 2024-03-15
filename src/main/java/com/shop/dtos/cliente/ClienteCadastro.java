package com.shop.dtos.cliente;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;

public record ClienteCadastro(
		@NotBlank(message = "Nome não pode ser vazio") String nome,
		@NotBlank(message = "CPF não pode ser vazio") @CPF String cpf) {

}
