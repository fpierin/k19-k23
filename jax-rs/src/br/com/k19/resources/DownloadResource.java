package br.com.k19.resources;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class DownloadResource {

	@GET
	@Path("/texto")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTexto() {
		final File file = new File("texto.txt");
		final ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"texto.txt\"");
		return response.build();
	}
	
	@GET
	@Path("/imagem")
	@Produces("image/png")	
	public Response getImagem() {
		final File file = new File("k19-logo.png");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"k19-logo.png\"");
		return response.build();
	}
	
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPDF() {
		final File file = new File("k23-site.pdf");
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"k23-site.pdf\"");
		return response.build();

	}

}
