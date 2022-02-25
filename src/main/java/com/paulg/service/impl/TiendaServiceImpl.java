package com.paulg.service.impl;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paulg.dao.ITiendaDao;
import com.paulg.dto.ReporteMontoVendidoDTO;
import com.paulg.dto.ReporteTransacionesTiendaDTO;
import com.paulg.helper.CSVHelper;
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

	@Override
	public ByteArrayInputStream transaccionesPorTienda() {
		List<ReporteTransacionesTiendaDTO> transacciones = new ArrayList<>();
		dao.listarTrasanccionesPorTienda().forEach(x -> {
			ReporteTransacionesTiendaDTO m = new ReporteTransacionesTiendaDTO();
			m.setTransacciones(Integer.valueOf(x[0].toString()));
			m.setTienda(String.valueOf(x[1]));
			Timestamp t = new Timestamp(((Date) x[2]).getTime());
			m.setFecha(t.toLocalDateTime());
			transacciones.add(m);
		});

		ByteArrayInputStream in = CSVHelper.tutorialsToCSV(transacciones);
		return in;
	}

	@Override
	public ByteArrayInputStream montoTotalVendido() {
		List<ReporteMontoVendidoDTO> transacciones = new ArrayList<>();
		dao.montoTotalVendido().forEach(x -> {
			ReporteMontoVendidoDTO m = new ReporteMontoVendidoDTO();
			m.setTotalmonto(Double.parseDouble(x[0].toString()));
			m.setTienda(String.valueOf(x[1]));
			m.setProducto(String.valueOf(x[2]));
			transacciones.add(m);
		});

		ByteArrayInputStream in = CSVHelper.montoTotalVendio(transacciones);
		return in;
	}

}
