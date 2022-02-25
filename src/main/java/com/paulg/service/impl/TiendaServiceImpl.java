package com.paulg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulg.dao.ITiendaDao;
import com.paulg.model.Tienda;
import com.paulg.service.ITiendaService;

@Service
public class TiendaServiceImpl implements ITiendaService {

	@Autowired
	private ITiendaDao dao;

	@Override
	public void registrar(Tienda t) {
		dao.save(t);
	}

	@Override
	public void modificar(Tienda t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Tienda listarId(int id) {
		Optional<Tienda> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Tienda();
	}

	@Override
	public List<Tienda> listar() {
		return dao.findAll();
	}

}
