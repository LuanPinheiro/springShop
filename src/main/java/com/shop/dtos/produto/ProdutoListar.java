package com.shop.dtos.produto;

import com.shop.models.Produto;

public record ProdutoListar(
		Long id,
		String nome,
		Integer estoque,
		Boolean disponivel) {

	public ProdutoListar(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getEstoque(), produto.isDisponivel());
	}
}
