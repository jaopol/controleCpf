package br.com.desafio;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.desafio.exception.ExistsCpfException;
import br.com.desafio.exception.InvalidCpfException;
import br.com.desafio.exception.NotFoundCpfException;
import br.com.desafio.model.Cpf;
import br.com.desafio.repository.CpfRepository;
import br.com.desafio.service.imp.CpfServiceImp;


@RunWith( SpringRunner.class )
@DataJpaTest
public class CpfRepositoryTest {
		
	
	CpfServiceImp cpfService;
	
	@Autowired
	private CpfRepository cpfRepository;
	
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {
		cpfService = new CpfServiceImp();
		cpfService.setCpfRepository( cpfRepository );
		
	}
	
	@Test
	public void addCpfTest() {
		
		Cpf cpf = new Cpf( "40988768259", null );
		cpfService.addCpf( cpf );
		Optional<Cpf> cpfEntity = cpfService.findById( "40988768259" );
		
		Assert.assertEquals( cpfEntity.get().getCpf(), "40988768259" );
		
	}
	
	@Test
	public void addInvalidCpfTest() {
		
		Cpf cpf = new Cpf( "12345678910", null );
		
		thrown.expect( InvalidCpfException.class );
		cpfService.addCpf( cpf );
		
	}
	
	@Test
	public void addSequenceNumberCpfTest() {
		
		Cpf cpf = new Cpf( "11111111111", null );
		thrown.expect( InvalidCpfException.class );
		cpfService.addCpf( cpf );
		
	}
	
	@Test
	public void addRepitedCpfTest() {
		
		Cpf cpf = new Cpf( "40988768259", null );
		thrown.expect( ExistsCpfException.class );
		cpfService.addCpf( cpf );
		cpfService.addCpf( cpf );
	}
	
	@Test
	public void checkCpfTest() {
		
		Cpf cpf = new Cpf( "40988768259", null );
		cpfService.addCpf( cpf );
		Optional<Cpf> cpfEntity = cpfService.findById( "40988768259" );
		
		Assert.assertEquals( cpfEntity.get().getCpf(), "40988768259" );
		Assert.assertNotNull( cpfEntity.get().getCreatedAt() );
	}
	
	@Test
	public void findAllCpfTest() {
		
		List<Cpf> findAll = cpfService.findAll();
		
		Assert.assertNotNull( findAll );
	}
	
	
	@Test
	public void checkNoExistsCpfTest() {
		
		thrown.expect( NotFoundCpfException.class );
		cpfService.findById( "40988768259" );
		
	}
	
	@Test
	public void checkInvalidCpfTest() {
		
		thrown.expect( InvalidCpfException.class );
		cpfService.findById( "12345678910" );
		
	}
	
	@Test
	public void removeNoExistsCpfTest() {
		
		thrown.expect( NotFoundCpfException.class );
		cpfService.deleteCpf( "40988768259" );
		
	}
	
	@Test
	public void removeInvalidCpfTest() {
		
		thrown.expect( InvalidCpfException.class );
		cpfService.deleteCpf( "12345678910" );
		
	}

}
