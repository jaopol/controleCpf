package br.com.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.UNPROCESSABLE_ENTITY )
public class ExistsCpfException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExistsCpfException( String exception ) {
		super( exception ); 
	}

}
