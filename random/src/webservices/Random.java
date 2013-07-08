package webservices;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class Random {
	
	@Resource
	WebServiceContext wsc;

	@WebMethod
	@WebResult(name = "resultado")
	public double next(@WebParam(name = "maximo") final double max) {
		MessageContext mc = wsc.getMessageContext();
		Map<?, ?> headers = (Map<?, ?>) mc.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<?> usernameList = (List<?>) headers.get("user");
		List<?> passwordList = (List<?>) headers.get("pass");
		
		String username = usernameList != null ? usernameList.get(0).toString() : null;
		String password = passwordList != null ? passwordList.get(0).toString() : null;
		
		System.out.println(username);
		System.out.println(password);
		
		if("k19".equals(username) && "k23".equals(password)) {
			return Math.random() * max;
		} else {
			throw new RuntimeException("usuário do senha incorretos");
		}
	}
	
}
