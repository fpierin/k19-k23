package receptores;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;

public class AssinanteDeNoticiasPorCategoria {

	public static void main(final String[] args) throws Exception {
		// Serviço de nomes - JNDI
		final Properties environment = new Properties();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		environment.put(Context.PROVIDER_URL, "remote://localhost:4447");
		environment.put(Context.SECURITY_PRINCIPAL, "xpto");
		environment.put(Context.SECURITY_CREDENTIALS, "jboss");
		final InitialContext ic = new InitialContext(environment);
		
		// Fábrica de conexões JMS
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
		
		// Tópico
		final Topic topic = (Topic) ic.lookup("jms/noticias");
		
		// Conexão JMS
		final Connection connection = factory.createConnection("xpto","jboss");
		
		// Sessão JMS
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// Receptor de mensagens
		final MessageConsumer receiver = session.createConsumer(topic, "(categoria = 'esporte')");
		
		// Inicializa conexão
		connection.start();
		
		// Recebendo
		TextMessage message = (TextMessage) receiver.receive();
		System.out.println(message.getText());
		
		// fechando
		receiver.close();
		session.close();
		connection.close();

		System.out.println("FIM");
		System.exit(0);
	}

}
