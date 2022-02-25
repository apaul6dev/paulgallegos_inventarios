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

import com.paulg.exception.ModelNotFoundException;
import com.paulg.exception.NumberNotValidException;
import com.paulg.model.Producto;
import com.paulg.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> obj = new ArrayList<>();
		obj = service.listar();
		return new ResponseEntity<List<Producto>>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> listarId(@PathVariable("id") Integer id) {
		Producto obj = new Producto();
		obj = service.listarId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID: " + id);
		}
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Producto obj) {
		service.registrar(obj);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdProducto()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@Valid @RequestBody Producto obj) {
		service.modificar(obj);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	/**
	 * Actualizacion del stock solo si la cantidad a actualizar es mayor a 0
	 * 
	 * @param id
	 * @param stock
	 * @return
	 */
	@PutMapping(value = "/actualizarStock/{id}/{stock}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizarStock(@PathVariable("id") Integer id,
			@PathVariable("stock") Integer stock) {
		Producto obj = new Producto();
		obj = service.listarId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			if (stock > 0) {
				int stockTmp = obj.getStock() + stock;
				obj.setStock(stockTmp);
				service.modificar(obj);
			} else {
				throw new NumberNotValidException("ID: " + id);
			}
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable("id") Integer id) {
		Producto obj = service.listarId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
