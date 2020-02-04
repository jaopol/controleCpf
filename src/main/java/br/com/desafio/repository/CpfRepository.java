package br.com.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Cpf;

@Repository
public interface CpfRepository extends CrudRepository<Cpf, String> {

	
}
