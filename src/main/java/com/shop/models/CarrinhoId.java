package com.shop.models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CarrinhoId implements Serializable{

	@Column(name = "cliente_id")
	private Long clienteId;
	@Column(name = "produto_id")
	private Long produtoId;
	
	public CarrinhoId() {}
	
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getProdutoId() {
		return produtoId;
	}
	public void setProduto_id(Long produtoId) {
		this.produtoId = produtoId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(clienteId, produtoId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoId other = (CarrinhoId) obj;
		return Objects.equals(clienteId, other.clienteId) && Objects.equals(produtoId, other.produtoId);
	}
}
