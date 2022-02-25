package com.paulg.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paulg.dao.ITiendaDao;
import com.paulg.model.Tienda;

@SpringBootTest
public class TestTiendaServiceImpl {
	@Autowired
	private ITiendaDao tiendaDao;

	@Test
	public void crearTienda() {
		Tienda tienda = new Tienda();
		tienda.setNombre("Tienda Test");
		Tienda retorno = tiendaDao.save(tienda);
		tiendaDao.deleteById(retorno.getIdTienda());
		assertTrue(tienda.getNombre().equals(retorno.getNombre()));
	}

}
