package com.shop.models;

import com.shop.dtos.produto.ProdutoCadastro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer estoque;
	private Boolean disponivel;
	
	public Produto() {
		this.disponivel = false;
	}
	
	public Produto(ProdutoCadastro produto) {
		this.nome = produto.nome();
		this.estoque = produto.estoque();
		this.disponivel = true;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	public Boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	
}
