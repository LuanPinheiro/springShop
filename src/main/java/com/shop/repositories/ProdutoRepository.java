package com.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public Optional<Produto> findByNome(String nome);
	public Optional<Produto> findByIdAndDisponivelTrue(Long id);
}
