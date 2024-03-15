package com.shop.dtos.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoCadastro(
		@NotBlank(message = "Nome não pode ser vazio") String nome,
		@NotNull(message = "Estoque precisa ser indicado") Integer estoque) {
}
