package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulg.model.Producto;

@Repository
public interface IProductoDao extends JpaRepository<Producto, Integer> {

}
