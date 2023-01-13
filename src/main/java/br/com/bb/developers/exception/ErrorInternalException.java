package br.com.bb.developers.exception;

/**
 * @author proitec-legacy 
 * Parametro de configuração error 500
 */

public class ErrorInternalException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ErrorInternalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ErrorInternalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
    
}
