package com.paulg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paulg.model.Tienda;

@Repository
public interface ITiendaProductoDao extends JpaRepository<Tienda, Integer> {

	@Modifying
	@Query(value = "INSERT INTO tienda_producto(id_tienda, id_producto) VALUES (:idTienda, :idProducto)", nativeQuery = true)
	int registrar(@Param("idTienda") Integer idTienda, @Param("idProducto") Integer idProducto);

}
