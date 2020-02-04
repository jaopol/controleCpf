package br.com.desafio.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.dto.CpfDTO;
import br.com.desafio.model.Cpf;
import br.com.desafio.response.Response;
import br.com.desafio.service.CpfService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( value = "API Desafio")
@RestController
@RequestMapping( "/cpf" )
public class CpfController {
	
	@Autowired
	private CpfService service;
	
	@ApiOperation( value = "Grava um CPF" )
	@PostMapping( name="/add" )
	public ResponseEntity<Response> addCpf( @RequestBody Cpf cpf ) {
		
		Response response = new Response();
		
		service.addCpf( cpf );
		response.setStausCode( HttpStatus.NO_CONTENT.value() );

		return ResponseEntity.ok( response );

	}
	
	@ApiOperation( value = "Retorna um CPF específico" )
	@GetMapping( name = "/checkCpf", value = "/{cpf}" )
	public ResponseEntity<CpfDTO> checkCpf( @RequestParam String cpf ){
		
		Optional<Cpf> cpfEntity = service.findById( cpf );
		
		return ResponseEntity.ok().body( new CpfDTO( cpfEntity.get() ) );
	}
	
	@ApiOperation( value = "Retorna todos CPFs cadastrados" )
	@GetMapping( name = "/findAll" )
	public ResponseEntity<List<CpfDTO>> findAll(){
		
		List<Cpf> listCpf = service.findAll();
		List<CpfDTO> listCpfDto = listCpf.stream().map( obj -> new CpfDTO( obj ) )
				.collect( Collectors.toList() );
		
		return ResponseEntity.ok().body( listCpfDto );
	}
	
	
	@ApiOperation( value = "Exclui um CPF específico" )
	@DeleteMapping( name="/delete", value = "/{cpf}" )
	public ResponseEntity<Void> deleteCpf( @RequestParam String cpf ) {
		
		try {
			
			Boolean removed = service.deleteCpf( cpf );
			
			if( removed ) {
				return ResponseEntity.noContent().build(); 
			}

			return ResponseEntity.notFound().build();

		} catch (Exception e) {
			
			return 	ResponseEntity.status( HttpStatus.UNPROCESSABLE_ENTITY ).build();
		}
		
	}
	
}
