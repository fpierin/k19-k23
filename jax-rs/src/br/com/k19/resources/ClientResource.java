package br.com.k19.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.k19.entities.Cliente;
import br.com.k19.repository.ClientDAO;
import br.com.k19.repository.ClientRepository;

@Path("/clientes")
public class ClientResource {
	
	private final static ClientRepository clientRepository = new ClientDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> lista() {
		return clientRepository.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(final Cliente client) {
		clientRepository.create(client);
		return Response.ok("Usuário adicionado com sucesso").build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response edit(@PathParam("id") final Integer id, final Cliente client) {
		final Cliente cliente = clientRepository.findById(id);
		if (cliente == null) {
			return Response.status(400).build();	
		} else {
			clientRepository.update(client);
			return Response.ok("Usuário atualizado com sucesso").build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response edit(@PathParam("id") final Integer id) {
		final Cliente cliente = clientRepository.findById(id);
		if (cliente == null) {
			return Response.status(400).build();
		} else {
			clientRepository.delete(cliente);
			return Response.ok("Usuário removido com sucesso").build();
		}
	}	

}
