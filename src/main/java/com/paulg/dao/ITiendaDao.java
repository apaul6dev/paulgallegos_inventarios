package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulg.model.Tienda;

@Repository
public interface ITiendaDao extends JpaRepository<Tienda, Integer> {

}
