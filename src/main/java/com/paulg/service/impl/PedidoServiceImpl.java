package com.paulg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulg.dao.IPedidoDao;
import com.paulg.dao.IPedidoDetalleDao;
import com.paulg.dao.IProductoDao;
import com.paulg.exception.NumberNotValidException;
import com.paulg.model.Pedido;
import com.paulg.model.PedidoDetalle;
import com.paulg.model.Producto;
import com.paulg.service.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService {

	@Autowired
	private IPedidoDao dao;

	@Autowired
	private IPedidoDetalleDao detalleDao;

	@Autowired
	private IProductoDao productoService;

	@Transactional
	@Override
	public void registrar(Pedido t) {
		List<PedidoDetalle> detalles = t.getPedidoDetalle();
		t.setPedidoDetalle(null);
		Pedido p = dao.save(t);

		for (PedidoDetalle rs : detalles) {
			rs.setPedido(p);
			Producto producto = this.stockValido(rs.getTiendaProducto().getProducto().getIdProducto(),rs.getCantidad());
			rs.getTiendaProducto().setProducto(producto);
			detalleDao.save(rs);
		}

	}

	private Producto stockValido(int idProducto, int cantidad) {
		Producto producto = productoService.getById(idProducto);
		int cantidadProd = producto.getStock() - cantidad;
		if (cantidadProd < -10) {
			throw new NumberNotValidException("Unidades no disponibles (> 10)");
		} else if (cantidadProd == -10) {
			int stockTmp = producto.getStock() + 10;
			producto.setStock(stockTmp);
			productoService.save(producto);
			producto.setStock(0);
		} else {
			producto.setStock(cantidadProd);
		}
		return productoService.save(producto);
	}

	@Override
	public void modificar(Pedido t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Pedido listarId(int id) {
		Optional<Pedido> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Pedido();
	}

	@Override
	public List<Pedido> listar() {
		return dao.findAll();
	}
}
