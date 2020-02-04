package br.com.desafio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.desafio.model.Cpf;

@Service
public interface CpfService {
	
	/**
	 * Grava um CPF
	 * 
	 * @param Cpf
	 */
	Cpf addCpf( Cpf cpf );

	/**
	 * Recupera todos os CPFs cadastrados
	 * 
	 * @param Cpf
	 * @return list 
	 */
	List<Cpf> findAll();
	
	/**
	 * Recupera um CPF especifico
	 * 
	 * @param Cpf
	 * @return Cpf
	 */
	Optional<Cpf> findById( String cpf );
	
	/**
	 * Exclui um CPF especifico
	 * 
	 * @param Cpf
	 * @return Boolean
	 */
	Boolean deleteCpf( String cpf );
	

}
