package com.raphael.workshopmongo.services.exception;

//Usar classe auxiliar para tratar a exceção 
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L; 
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
