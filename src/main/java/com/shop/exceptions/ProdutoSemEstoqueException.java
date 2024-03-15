package com.shop.exceptions;

public class ProdutoSemEstoqueException extends MessageRuntimeException {

	public ProdutoSemEstoqueException(String nomeProduto) {
		super(nomeProduto + " não possui estoque disponível");
	}
}
