package br.com.desafio.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import br.com.desafio.model.Cpf;
import lombok.Data;

@Data
@Component
public class CpfDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cpf;
	private String createdAt;
	

	public CpfDTO() {

	}

	public CpfDTO( Cpf cpf ) {
		this.cpf = cpf.getCpf();
		this.createdAt = cpf.getCreatedAt() != null ? cpf.getCreatedAt().toString() : "";
	}
	
}

