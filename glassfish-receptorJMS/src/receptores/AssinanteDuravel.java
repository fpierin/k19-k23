package receptores;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class AssinanteDuravel {

	public static void main(final String[] args) throws Exception {
		// Serviço de nomes - JNDI
		final InitialContext ic = new InitialContext();
		
		// Fábrica de conexões JMS
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
		
		// Tópico
		final Topic topic = (Topic) ic.lookup("jms/noticias");
		
		// Conexão JMS
		final Connection connection = factory.createConnection();
		
		// Sessão JMS
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// Receptor de mensagens
		final MessageConsumer receiver = session.createConsumer(topic);
		
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
