package emissores;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class EnviaNovoPedido {

	public static void main(final String[] args) throws Exception {
		// Serviço de nomes JNDI
		final Properties environment = new Properties();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		environment.put(Context.PROVIDER_URL, "remote://localhost:4447");
		environment.put(Context.SECURITY_PRINCIPAL, "xpto");
		environment.put(Context.SECURITY_CREDENTIALS, "jboss");
		final InitialContext ic = new InitialContext(environment);
		
		// Fábrica de conexões JMS
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
		
		// Fila
		final Queue queue = (Queue) ic.lookup("jms/pedidos");
		
		// Conexão JMS
		final Connection connection = factory.createConnection("xpto", "jboss");
		
		// Sessão JMS
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// Emissor de mensagens
		final MessageProducer sender = session.createProducer(queue);
		
		// Mensagem
		TextMessage message = session.createTextMessage();
		message.setText("Uma pizza de cinco queijos e uma coca-cola 21 - " + System.currentTimeMillis());
		
		// Enviando a mensagem
		sender.send(message);
		
		// Fechando
		sender.close();
		session.close();
		connection.close();
		
		System.out.println("Mensagem enviada");
		System.exit(0);
		
	}

}
