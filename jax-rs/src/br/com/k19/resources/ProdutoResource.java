package br.com.k19.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.k19.entities.Produto;

@Path("/produtos")
public class ProdutoResource {

	@GET
	@Path("/{id}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Produto getProdutoAsXML(@PathParam("id") final long id) {
		return geraProdutoFalso(id);
	}
	
	@GET
	@Path("/{id}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProdutoAsJSON(@PathParam("id") final long id) {
		return geraProdutoFalso(id);
	}	

	private Produto geraProdutoFalso(final long id) {
		final Produto p = new Produto();
		p.setNome("produto" + id);
		p.setPreco(50.0 * id);
		p.setId(id);
		return p;
	}
	
}
