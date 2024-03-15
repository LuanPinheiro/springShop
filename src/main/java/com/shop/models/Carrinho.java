package com.shop.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Carrinho {

	@EmbeddedId
	private CarrinhoId carrinhoId;
	@ManyToOne
	@MapsId("produtoId")
	@JoinColumn(name = "produto_id")
	private Produto produto;
	@ManyToOne
	@MapsId("clienteId")
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	private int quantidade;
	
	public Carrinho() {}
	
	public CarrinhoId getCarrinhoId() {
		return carrinhoId;
	}
	public void setCarrinhoId(CarrinhoId carrinhoId) {
		this.carrinhoId = carrinhoId;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
