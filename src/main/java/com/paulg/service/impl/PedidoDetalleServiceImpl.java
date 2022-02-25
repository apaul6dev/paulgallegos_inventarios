package com.paulg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulg.dao.IPedidoDetalleDao;
import com.paulg.model.PedidoDetalle;
import com.paulg.service.IPedidoDetalleService;

@Service
public class PedidoDetalleServiceImpl implements IPedidoDetalleService {

	@Autowired
	private IPedidoDetalleDao dao;

	@Override
	public void registrar(PedidoDetalle t) {
		dao.save(t);
	}

	@Override
	public void modificar(PedidoDetalle t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public PedidoDetalle listarId(int id) {
		Optional<PedidoDetalle> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new PedidoDetalle();
	}

	@Override
	public List<PedidoDetalle> listar() {
		return dao.findAll();
	}
}
