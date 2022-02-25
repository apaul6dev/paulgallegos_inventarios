package com.paulg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulg.dao.IProductoDao;
import com.paulg.dao.ITiendaDao;
import com.paulg.dao.ITiendaProductoDao;
import com.paulg.dto.TiendaProductosDTO;
import com.paulg.model.Producto;
import com.paulg.model.Tienda;
import com.paulg.service.ITiendaProductosService;

@Service
public class TiendaProductosServiceImpl implements ITiendaProductosService {

	@Autowired
	private ITiendaProductoDao tpdao;

	@Autowired
	private ITiendaDao tienda;

	@Autowired
	private IProductoDao producto;

	@Transactional
	@Override
	public Tienda registrar(TiendaProductosDTO dto) {
		Tienda cons = tienda.save(dto.getTienda());		
		dto.getProductos().forEach(e -> {
			Producto p = producto.save(e);
			tpdao.registrar(dto.getTienda().getIdTienda(), p.getIdProducto());
		});
		return cons;
	}
}
