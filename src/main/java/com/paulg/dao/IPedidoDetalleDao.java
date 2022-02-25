package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paulg.model.PedidoDetalle;

public interface IPedidoDetalleDao extends JpaRepository<PedidoDetalle, Integer>{

}
