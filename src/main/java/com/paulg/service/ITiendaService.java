package com.paulg.service;

import java.io.ByteArrayInputStream;

import com.paulg.model.Tienda;

public interface ITiendaService extends ICRUD<Tienda> {
	
	public ByteArrayInputStream transaccionesPorTienda();
	public ByteArrayInputStream montoTotalVendido();
	
}
