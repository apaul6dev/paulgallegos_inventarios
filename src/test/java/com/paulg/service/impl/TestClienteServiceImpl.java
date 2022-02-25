package com.paulg.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paulg.dao.IClienteDao;
import com.paulg.model.Cliente;

@SpringBootTest
public class TestClienteServiceImpl {

	@Autowired
	private IClienteDao dao;

	@Test
	public void crearDestruirCliente() {
		Cliente o = new Cliente();
		o.setIdentificacion("12323123123");
		o.setNombre("Cliente 111");
		
		Cliente retorno = dao.save(o);
		
		dao.deleteById(retorno.getIdCliente());
		
		assertTrue(o.getIdentificacion().equals(retorno.getIdentificacion()));
	}

}
