package br.com.desafio.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.desafio.exception.ExistsCpfException;
import br.com.desafio.exception.InvalidCpfException;
import br.com.desafio.exception.NotFoundCpfException;
import br.com.desafio.model.Cpf;
import br.com.desafio.repository.CpfRepository;
import br.com.desafio.service.CpfService;
import lombok.Data;

@Service
@Data
public class CpfServiceImp implements CpfService {
	
	@Autowired
	private CpfRepository cpfRepository;
	
	public Cpf addCpf( Cpf cpf ) {

		validatorCpf( cpf.getCpf() );
		checkExistCpf( cpf.getCpf() );
		
		cpf.setCreatedAt( new Date() );
		
		return cpfRepository.save( cpf );
	}


	public List<Cpf> findAll() {
		
		return (List<Cpf>) cpfRepository.findAll();
		
	}

	public Optional<Cpf> findById( String cpf ) {
		
		validatorCpf( cpf );
		
		Optional<Cpf> cpfEntity = cpfRepository.findById( cpf );
		
		if( !cpfEntity.isPresent() ) {
			throw new NotFoundCpfException("CPF not exists");
		}
		
		return cpfRepository.findById( cpf );
	}

	public Boolean deleteCpf( String cpf ) {
		
		Optional<Cpf> cpfEntity = this.findById(cpf);
		
		if( cpfEntity.isPresent() ) {
			cpfRepository.deleteById( cpfEntity.get().getCpf() );
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;

	}
	
	/**
	 * 
	 *Utilizado para validar o CPF. Lança InvalidCpfException para CPF inválido 
	 *
	 */
	private void validatorCpf(String cpf) {
		
		CPFValidator cpfValidator = new CPFValidator();
		
		try {
			
			cpfValidator.assertValid( cpf );
			
		} catch (InvalidStateException e) {
			throw new InvalidCpfException( "CPF is not valid." );
		}
		
	}
	
	/**
	 * 
	 *Utilizado para verificar se existe o CPF cadastrado. Lança ExistsCpfException para CPF não cadastrado. 
	 *
	 */
	private void checkExistCpf(String cpf) {
		
		Optional<Cpf> cpfEntity = cpfRepository.findById( cpf );
		
		if( cpfEntity.isPresent() ) {
			throw new ExistsCpfException("CPF already exists.");
		}
		
	}

}
