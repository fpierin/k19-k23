package br.com.k19.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.k19.entities.Produto;

@Path("/produtos/converte")
public class ConversosDeProdutoResource {

	@POST
	@Path("/json/xml")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Produto jsonToXml(final Produto p) {
		return p;
	}
	
	@POST
	@Path("/xml/json")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Produto xmlToJson(final Produto p) {
		return p;
	}	

}
