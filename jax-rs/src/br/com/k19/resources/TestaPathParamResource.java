package br.com.k19.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/path-param")
public class TestaPathParamResource {

	@GET
	@Path("/{p1}/{p2}")
	@Produces(MediaType.TEXT_PLAIN)
	public String pathParam(@PathParam("p1") String p1, @PathParam("p2") String p2) {
		return "P1 = " + p1 + ", P2 = " + p2;
	}

}
