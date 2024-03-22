package com.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dtos.produto.ProdutoCadastro;
import com.shop.dtos.produto.ProdutoListar;
import com.shop.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ProdutoListar> getProdutos(
			@RequestParam(name = "page", required = false) Integer page,
			@RequestParam(name = "disponivel", required = false) Boolean disponivel){
		return produtoService.getProdutos(page != null ? page : 0, disponivel);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postProduto(@Valid @RequestBody ProdutoCadastro produto) {
		produtoService.postProduto(produto);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void putProduto(@RequestParam(name = "id") Long id, @RequestBody ProdutoCadastro produto) {
		produtoService.putProduto(produto, id);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduto(@RequestParam("id") Long id) {
		produtoService.deleteProduto(id);
	}
}
