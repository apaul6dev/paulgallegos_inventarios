package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulg.model.Pedido;

@Repository
public interface IPedidoDao extends JpaRepository<Pedido, Integer> {

}
