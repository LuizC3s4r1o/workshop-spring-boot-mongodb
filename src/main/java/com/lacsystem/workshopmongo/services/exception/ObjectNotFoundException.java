package com.lacsystem.workshopmongo.services.exception;

/**
 * @author Luiz.Cesario
 *
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

}
