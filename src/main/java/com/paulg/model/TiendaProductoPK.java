package com.paulg.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class TiendaProductoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_tienda", nullable = false)
	private Tienda tienda;

	@ManyToOne
	@JoinColumn(name = "id_producto", nullable = false)
	private Producto producto;

	@Override
	public int hashCode() {
		return Objects.hash(producto, tienda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiendaProductoPK other = (TiendaProductoPK) obj;
		return Objects.equals(producto, other.producto) && Objects.equals(tienda, other.tienda);
	}

}
