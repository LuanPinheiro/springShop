package com.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
