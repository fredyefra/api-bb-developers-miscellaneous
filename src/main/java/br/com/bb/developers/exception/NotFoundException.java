package br.com.bb.developers.exception;

/**
 * @author proitec-legacy 
 * Parametro de configuração error 404
 */
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
