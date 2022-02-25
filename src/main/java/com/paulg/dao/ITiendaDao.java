package com.paulg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paulg.model.Tienda;

@Repository
public interface ITiendaDao extends JpaRepository<Tienda, Integer> {
	
	@Query(value="select count(pd.id_tienda) transacciones, t.nombre tienda, date(p.fecha) fecha from pedido p inner join pedido_detalle pd on(p.id_pedido = pd.id_pedido) inner join tienda t on (pd.id_tienda = t.id_tienda) group by pd.id_tienda,t.nombre, date(p.fecha)", nativeQuery = true)
	List<Object[]> listarTrasanccionesPorTienda();
	
	@Query(value="select "
			+ "	sum(pd.cantidad) * price totalmonto, "
			+ "	t.nombre tienda, "
			+ "	pro.\"name\" producto "
			+ "from pedido_detalle pd "
			+ "inner join tienda t on (pd.id_tienda = t.id_tienda) "
			+ "inner join producto pro on (pro.id_producto = pd.id_producto) "
			+ "group by "
			+ "	pd.cantidad, "
			+ "	t.nombre , "
			+ "	pro.\"name\" , "
			+ "	pro.price ", nativeQuery = true)
	List<Object[]> montoTotalVendido();
	
}
