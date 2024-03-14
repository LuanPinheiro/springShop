package com.shop.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Page<Cliente> findByAtivoTrue(Pageable pageable);
	public Optional<Cliente> findByCpf(String cpf);
}
