package com.paulg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedidoDetalle;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_pedido", nullable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "id_tienda", nullable = false),
			@JoinColumn(name = "id_producto", nullable = false) })
	private TiendaProducto tiendaProducto;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getIdPedidoDetalle() {
		return idPedidoDetalle;
	}

	public void setIdPedidoDetalle(int idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}

	public TiendaProducto getTiendaProducto() {
		return tiendaProducto;
	}

	public void setTiendaProducto(TiendaProducto tiendaProducto) {
		this.tiendaProducto = tiendaProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
