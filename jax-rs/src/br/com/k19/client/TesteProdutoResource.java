package br.com.k19.client;

import br.com.k19.entities.Produto;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class TesteProdutoResource {

	public static void main(final String[] args) {
		final Client client = Client.create();
		final WebResource resourceXml = client.resource("http://localhost:8080/produtos/1/xml");
		System.out.println("TESTANDO COM XML");
		final String xml = resourceXml.get(String.class);
		System.out.println(xml);
		
		final Produto produto = resourceXml.get(Produto.class);
		System.out.println(produto.getId());
		System.out.println(produto.getNome());
		System.out.println(produto.getPreco());
		
		final WebResource resourceJSON = client.resource("http://localhost:8080/produtos/1/json");
		System.out.println("TESTANDO COM JSON");
		
		final String json = resourceJSON.get(String.class);
		System.out.println(json);
		
		final Produto produto2 = resourceJSON.get(Produto.class);
		System.out.println(produto2.getId());
		System.out.println(produto2.getNome());
		System.out.println(produto2.getPreco());		
	}

}
