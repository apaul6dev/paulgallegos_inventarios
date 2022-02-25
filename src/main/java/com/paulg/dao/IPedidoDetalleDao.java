package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulg.model.PedidoDetalle;

@Repository
public interface IPedidoDetalleDao extends JpaRepository<PedidoDetalle, Integer>{

}
