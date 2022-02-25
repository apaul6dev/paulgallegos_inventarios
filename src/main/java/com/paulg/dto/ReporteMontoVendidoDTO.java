package com.paulg.dto;

public class ReporteMontoVendidoDTO {
	private double totalmonto;
	private String tienda;
	private String producto;

	public double getTotalmonto() {
		return totalmonto;
	}

	public void setTotalmonto(double totalmonto) {
		this.totalmonto = totalmonto;
	}

	public String getTienda() {
		return tienda;
	}

	public void setTienda(String tienda) {
		this.tienda = tienda;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

}
