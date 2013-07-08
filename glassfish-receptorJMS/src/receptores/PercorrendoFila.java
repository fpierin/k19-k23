package receptores;

import java.util.Enumeration;
import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class PercorrendoFila {

	public static void main(final String[] args) throws Exception {
		// Serviço de nomes JNDI
		final InitialContext ic = new InitialContext();
		
		// Fábrica de conexões JMS
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
		
		// Fila
		final Queue queue = (Queue) ic.lookup("jms/pedidos");
		
		// conexão JMS
		final Connection connection = factory.createConnection();
		
		// sessao JMS
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// Queue browser
		final QueueBrowser browser = session.createBrowser(queue);
		
		final Enumeration<TextMessage> messages = browser.getEnumeration();
		int count = 1;
		while (messages.hasMoreElements()) {
			final TextMessage message = messages.nextElement();
			System.out.println(count + " : " + message.getText());
			count++;
		}
		
		// fechando
		browser.close();
		session.close();
		connection.close();
		
		System.out.println("FIM");
		System.exit(0);
	}

}
