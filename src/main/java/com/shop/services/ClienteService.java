package com.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.shop.dtos.cliente.ClienteCadastro;
import com.shop.dtos.cliente.ClienteListar;
import com.shop.exceptions.RegistroDeletedException;
import com.shop.exceptions.RegistroExistenteException;
import com.shop.exceptions.RegistroNotFoundException;
import com.shop.models.Cliente;
import com.shop.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Page<ClienteListar> getClientes(int page) {
		return clienteRepository
				.findByAtivoTrue(PageRequest.of(0, 10))
				.map(ClienteListar::new);
	}

	public void postCliente(ClienteCadastro cliente) {
		Cliente novoCliente = clienteRepository
				.findByCpf(cliente.cpf())
				.orElse(new Cliente());
		
		if(novoCliente.isAtivo())
			throw new RegistroExistenteException("Cliente");
		
		novoCliente.setAtivo(true);
		novoCliente.setNome(cliente.nome());
		novoCliente.setCpf(cliente.cpf());
		clienteRepository.save(novoCliente);
	}
	
	public void putCliente(ClienteCadastro cliente, String cpf) {
		Cliente clienteEditado = clienteRepository
				.findByCpf(cpf)
				.orElseThrow(()-> new RegistroNotFoundException("Cliente"));
		
		clienteEditado.setCpf(cliente.cpf() != null ? cliente.cpf() : clienteEditado.getCpf());
		clienteEditado.setNome(cliente.nome() != null ? cliente.nome() : clienteEditado.getNome());
		clienteRepository.save(clienteEditado);
	}
	
	public void deleteCliente(String cpf) {
		Cliente cliente = clienteRepository
				.findByCpf(cpf)
				.orElseThrow(()-> new RegistroNotFoundException("Cliente"));
		
		if(!cliente.isAtivo())
			throw new RegistroDeletedException("Cliente");
		
		cliente.setAtivo(false);
		
		clienteRepository.save(cliente);
	}
}
