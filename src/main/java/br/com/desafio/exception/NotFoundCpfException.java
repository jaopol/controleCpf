package br.com.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND )
public class NotFoundCpfException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NotFoundCpfException( String exception ) {
		super( exception ); 
	}

}
