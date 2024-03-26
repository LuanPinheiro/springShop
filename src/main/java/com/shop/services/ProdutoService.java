package com.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.dtos.produto.ProdutoCadastro;
import com.shop.dtos.produto.ProdutoListar;
import com.shop.exceptions.RegistroDeletedException;
import com.shop.exceptions.RegistroExistenteException;
import com.shop.exceptions.RegistroNotFoundException;
import com.shop.models.Produto;
import com.shop.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Page<ProdutoListar> getProdutos(Integer page, Boolean disponivel) {
		Page<Produto> produtos;
		Pageable pageable = PageRequest.of(0, 10);
		
		if(disponivel != null)
			produtos = produtoRepository.findByDisponivel(disponivel, pageable);
		else
			produtos = produtoRepository.findAll(pageable);
		
			
		return produtos.map(ProdutoListar::new);
	}

	public void postProduto(ProdutoCadastro produto) {
		Produto novoProduto = produtoRepository
				.findByNome(produto.nome())
				.orElse(new Produto());
		
		if(novoProduto.isDisponivel())
			throw new RegistroExistenteException("Produto");
		
		novoProduto.setNome(produto.nome());
		novoProduto.setEstoque(produto.estoque());
		novoProduto.setDisponivel(produto.disponivel());
		produtoRepository.save(novoProduto);
	}
	
	public void putProduto(ProdutoCadastro produto, Long id) {
		Produto produtoEditado = produtoRepository
				.findById(id)
				.orElseThrow(()-> new RegistroNotFoundException("Produto"));
		
		produtoEditado.setNome(produto.nome() != null ? produto.nome() : produtoEditado.getNome());
		produtoEditado.setEstoque(produto.estoque() != null ? produto.estoque() : produtoEditado.getEstoque());
		produtoEditado.setDisponivel(produto.disponivel() != null ? produto.disponivel() : produtoEditado.isDisponivel());
		produtoRepository.save(produtoEditado);
	}
	
	public void deleteProduto(Long id) {
		Produto produto = produtoRepository
				.findById(id)
				.orElseThrow(()-> new RegistroNotFoundException("Produto"));
		
		if(!produto.isDisponivel())
			throw new RegistroDeletedException("Produto");
		
		produto.setDisponivel(false);
		produtoRepository.save(produto);
	}
}
