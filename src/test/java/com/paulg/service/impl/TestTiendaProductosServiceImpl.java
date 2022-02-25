package com.paulg.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.paulg.dao.IProductoDao;
import com.paulg.dao.ITiendaDao;
import com.paulg.dao.ITiendaProductoDao;
import com.paulg.dto.TiendaProductosDTO;
import com.paulg.model.Producto;
import com.paulg.model.Tienda;

@SpringBootTest
public class TestTiendaProductosServiceImpl {

	@Autowired
	private ITiendaProductoDao tpdao;

	@Autowired
	private ITiendaDao tienda;

	@Autowired
	private IProductoDao producto;
	
	@Transactional
	@Test
	public void cargarTiendaProductos() {
		Tienda t = new Tienda();
		t.setNombre("mi tienda");

		Producto p1 = new Producto();
		p1.setCod("test001");
		p1.setName("test001");
		p1.setPrice(0.44);
		p1.setStock(20);
		
		Producto p2 = new Producto();
		p2.setCod("test002");
		p2.setName("test002");
		p2.setPrice(0.40);
		p2.setStock(5);

		List<Producto> productos = new ArrayList<>();
		productos.add(p1);
		productos.add(p2);

		TiendaProductosDTO dto = new TiendaProductosDTO();
		dto.setTienda(t);
		dto.setProductos(productos);

		Tienda response = tienda.save(dto.getTienda());
		int contador = 0;
		for (Producto e : dto.getProductos()) {
			Producto p = producto.save(e);
			contador += tpdao.registrar(dto.getTienda().getIdTienda(), p.getIdProducto());
		}
		
		tienda.deleteById(response.getIdTienda());
		
		assertEquals(t.getNombre(), response.getNombre()); // verifica si se creo la campania
		assertEquals(dto.getProductos().size(), contador); // verificar si todos los productos ingresaro

	}

}
