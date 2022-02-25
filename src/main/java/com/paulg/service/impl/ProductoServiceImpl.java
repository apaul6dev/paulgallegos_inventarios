package com.paulg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulg.dao.IProductoDao;
import com.paulg.model.Producto;
import com.paulg.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private IProductoDao dao;

	@Override
	public void registrar(Producto t) {
		dao.save(t);
	}

	@Override
	public void modificar(Producto t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Producto listarId(int id) {
		Optional<Producto> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Producto();
	}

	@Override
	public List<Producto> listar() {
		return dao.findAll();
	}

}
