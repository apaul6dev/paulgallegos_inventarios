package com.paulg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NumberNotValidException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NumberNotValidException(String mensaje) {
		super(mensaje);
	}
}
