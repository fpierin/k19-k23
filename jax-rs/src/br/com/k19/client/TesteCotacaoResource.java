package br.com.k19.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TesteCotacaoResource {

	public static void main(final String[] args) {
		final Client client = Client.create();
		final WebResource resource = client.resource("http://localhost:8080/Cotacao/DollarToReal");
		final String cotacao = resource.get(String.class);
		System.out.println(cotacao);
	}

}
