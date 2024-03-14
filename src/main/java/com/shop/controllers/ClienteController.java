package com.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dtos.ClienteCadastro;
import com.shop.dtos.ClienteListar;
import com.shop.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<ClienteListar> getClientes(@RequestParam(name = "page", required = false) Integer page){
		return clienteService.getClientes(page != null ? page : 0);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postCliente(@Valid @RequestBody ClienteCadastro cliente) {
		clienteService.postCliente(cliente);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void putCliente(@RequestParam(name = "cpf") String cpf, @RequestBody ClienteCadastro cliente) {
		clienteService.putCliente(cliente, cpf);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void deleteCliente(@RequestParam("cpf") String cpf) {
		clienteService.deleteCliente(cpf);
	}
}
