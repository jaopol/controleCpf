package br.com.desafio.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type;
	private String message;

}
