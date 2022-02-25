package com.paulg.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulg.dto.TiendaProductosDTO;
import com.paulg.exception.ModelNotFoundException;
import com.paulg.model.Tienda;
import com.paulg.service.ITiendaProductosService;
import com.paulg.service.ITiendaService;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

	@Autowired
	private ITiendaService service;
	
	@Autowired
	private ITiendaProductosService tiendaProductoService;
	
	@PostMapping(value = "/setproductos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody TiendaProductosDTO dto) {

		Tienda c = tiendaProductoService.registrar(dto);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(c.getIdTienda())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Tienda>> listar() {
		List<Tienda> obj = new ArrayList<>();
		obj = service.listar();
		return new ResponseEntity<List<Tienda>>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tienda> listarId(@PathVariable("id") Integer id) {
		Tienda obj = new Tienda();
		obj = service.listarId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Tienda>(obj, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Tienda obj) {
		service.registrar(obj);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdTienda())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Tienda obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Integer id) {
		Tienda obj = service.listarId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
