package com.paulg.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.paulg.model.Pedido;
import com.paulg.service.IPedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private IPedidoService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Pedido obj) {
		service.registrar(obj);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdPedido())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
