package com.paulg.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulg.dao.IClienteDao;
import com.paulg.model.Cliente;
import com.paulg.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao dao;

	@Override
	public void registrar(Cliente t) {
		dao.save(t);
	}

	@Override
	public void modificar(Cliente t) {
		dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public Cliente listarId(int id) {
		Optional<Cliente> opt = dao.findById(id);
		return opt.isPresent() ? opt.get() : new Cliente();
	}

	@Override
	public List<Cliente> listar() {
		return dao.findAll();
	}

}
