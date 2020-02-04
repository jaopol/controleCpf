package br.com.desafio.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.desafio.exception.ExceptionResponse;
import br.com.desafio.exception.ExistsCpfException;
import br.com.desafio.exception.InvalidCpfException;
import br.com.desafio.exception.NotFoundCpfException;

@RestControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler( Exception.class )
	public final ResponseEntity<ExceptionResponse> handleAllException( Exception ex, WebRequest request ){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse( "" ,ex.getMessage() );
		return new ResponseEntity<>( exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR );
		
	}
	
	@ExceptionHandler( InvalidCpfException.class )
	public final ResponseEntity<ExceptionResponse> handleInvalidCpfException( Exception ex, WebRequest request ){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse( "InvalidCpfException", 
				ex.getMessage() );
		return new ResponseEntity<>( exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY );
		
	}
	
	@ExceptionHandler( ExistsCpfException.class )
	public final ResponseEntity<ExceptionResponse> handleExistsCpfException( Exception ex, WebRequest request ){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse( "ExistsCpfException", 
				ex.getMessage() );
		return new ResponseEntity<>( exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY );
		
	}
	
	@ExceptionHandler( NotFoundCpfException.class )
	public final ResponseEntity<ExceptionResponse> handleNotFountCpfException( Exception ex, WebRequest request ){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse( "NotFoundCpfException", 
				ex.getMessage() );
		return new ResponseEntity<>( exceptionResponse, HttpStatus.NOT_FOUND );
		
	}

}
