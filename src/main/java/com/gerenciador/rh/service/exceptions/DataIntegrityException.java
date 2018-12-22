package com.gerenciador.rh.service.exceptions;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(String msg) {
		super(msg);
	}

	public DataIntegrityException(String msg,Exception exception) {
		super(msg,exception);
	}

}
