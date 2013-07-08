package webservices;

import javax.xml.ws.Endpoint;

public class RandomPublisher {

	public static void main(final String[] args) {
		System.out.println("Random web service start...");
		final Random random = new Random();
		Endpoint.publish("http://localhost:9090/random", random);
	}

}
