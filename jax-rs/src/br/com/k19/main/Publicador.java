package br.com.k19.main;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class Publicador {

	public static void main(final String[] args) throws Exception {
		final HttpServer server = HttpServerFactory.create("http://localhost:8080/");
		server.start();
	}

}
