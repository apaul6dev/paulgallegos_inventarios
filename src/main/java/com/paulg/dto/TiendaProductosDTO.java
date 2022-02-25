package com.paulg.dto;

import java.util.List;

import com.paulg.model.Producto;
import com.paulg.model.Tienda;

public class TiendaProductosDTO {
	
	private Tienda tienda;
	private List<Producto> productos;

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
