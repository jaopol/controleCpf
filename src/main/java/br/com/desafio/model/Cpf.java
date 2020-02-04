package br.com.desafio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity()
@Table(name = "CPF")
@AllArgsConstructor
@NoArgsConstructor
public class Cpf implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	private Date createdAt;
	
	
}
