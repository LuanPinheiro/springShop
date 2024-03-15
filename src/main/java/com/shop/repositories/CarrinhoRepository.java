package com.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.models.Carrinho;
import com.shop.models.CarrinhoId;

public interface CarrinhoRepository extends JpaRepository<Carrinho, CarrinhoId> {

}
