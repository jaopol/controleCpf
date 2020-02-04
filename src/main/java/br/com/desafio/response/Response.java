package br.com.desafio.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Response {

	private Integer stausCode;
	private List<String> content;
	
	
	public Response() {
		
	}
	
	public List<String> getContent(){
		
		if( this.content == null ) {
			this.content = new ArrayList<String>();
		}
		
		return this.content;
	}
	
	
}
