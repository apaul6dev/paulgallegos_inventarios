package com.paulg.dto;

import java.time.LocalDateTime;

public class ReporteTransacionesTiendaDTO {
	private int transacciones;
	private String tienda;
	private LocalDateTime fecha;

	public int getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(int transacciones) {
		this.transacciones = transacciones;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
