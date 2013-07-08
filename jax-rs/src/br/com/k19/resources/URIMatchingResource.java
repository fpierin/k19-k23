package br.com.k19.resources;

import static java.lang.String.valueOf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/uri-matching")
public class URIMatchingResource {

	@GET
	@Path("/{a: \\d+}/{b: \\d+}")
	public String soma(@PathParam("a") double a, @PathParam("b") double b) {
		return valueOf(a + b);
	}
	
	@GET
	@Path("/{a}/{b}")
	@Produces(MediaType.TEXT_PLAIN)
	public String concatena(@PathParam("a") String a, @PathParam("b") String b) {
		return a + b;
	}

}
