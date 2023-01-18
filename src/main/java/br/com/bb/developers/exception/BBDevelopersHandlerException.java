package br.com.bb.developers.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author proitec
 * @see Classe responsavel por 'interceptar' as exceções advindas dos controllers é lançar o respectivo erro.
 */
@RestControllerAdvice
public class BBDevelopersHandlerException {

	/**
	 * @param exception
	 * @param request
	 * @return {@link NotFoundException}
	 */
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handlerNotFound(NotFoundException exception, HttpServletRequest request) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BBDevelopersException(System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getServletPath()));
	}

	/**
	 * @param exception
	 * @param request
	 * @return {@link ErrorInternalException}
	 */
	@ExceptionHandler(ErrorInternalException.class)
	public ResponseEntity<?> handlerErrorInternal(ErrorInternalException exception,
			HttpServletRequest request) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new BBDevelopersException(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
						exception.getMessage(), request.getServletPath()));
	}
}