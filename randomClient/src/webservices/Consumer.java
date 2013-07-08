package webservices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class Consumer {
	
	public static void main(final String[] args) {
		final RandomService randomService = new RandomService();
		final Random proxy = randomService.getRandomPort();
		
		final BindingProvider bp = (BindingProvider) proxy;
		final HashMap<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("user", Collections.singletonList("k19"));
		headers.put("pass", Collections.singletonList("k23"));
		bp.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		final double next = proxy.next(50);
		System.out.println(next);
	}

}
