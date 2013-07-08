package br.com.k19.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import br.com.k19.entities.Produto;

public class TesteConversosDeProdutoResource {

	public static void main(final String[] args) {
		final Produto p = new Produto();
		p.setId(2L);
		p.setNome("Felipe Pierin");
		p.setPreco(45.67);
		
		final Client client = Client.create();
		System.out.println("Convertendo para XML");
		
		final WebResource resource = client.resource("http://localhost:8080/produtos/converte/json/xml");
		final String xml = resource.type(MediaType.APPLICATION_JSON).post(String.class, p);
		System.out.println(xml);
		
		System.out.println("Convertendo para JSON");
		final WebResource resource2 = client.resource("http://localhost:8080/produtos/converte/xml/json");
		final String json = resource2.type(MediaType.APPLICATION_XML).post(String.class, p);
		System.out.println(json);
	}

}
