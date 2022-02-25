package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paulg.model.Cliente;

@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer> {

}
