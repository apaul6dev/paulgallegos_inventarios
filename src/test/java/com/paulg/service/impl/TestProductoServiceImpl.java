package com.paulg.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paulg.dao.IProductoDao;
import com.paulg.model.Producto;

@SpringBootTest
public class TestProductoServiceImpl {
	
	@Autowired
	private IProductoDao dao;

	@Test
	public void crearProducto() {
		Producto p1 = new Producto();
		p1.setCod("test001");
		p1.setName("test001");
		p1.setPrice(0.44);
		p1.setStock(20);
		Producto retorno = dao.save(p1);
		dao.deleteById(retorno.getIdProducto());
		assertTrue(p1.getCod().equals(retorno.getCod()));
	}

}
