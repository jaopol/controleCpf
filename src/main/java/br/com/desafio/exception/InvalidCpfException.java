package br.com.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST )
public class InvalidCpfException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidCpfException( String exception ) {
		super( exception ); 
	}

}
