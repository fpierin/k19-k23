package br.com.k19.resources;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/matrix-param")
public class TestaMatrixParamResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String pathParam(@MatrixParam("p1") String p1, @MatrixParam("p2") String p2) {
		return "P1 = " + p1 + ", P2 = " + p2;
	}

}
