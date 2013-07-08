package receptores;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class RecebePedido {

	public static void main(final String[] args) throws Exception {
		// Serviço de nomes - JNDI
		final InitialContext ic = new InitialContext();
		
		// Fábrica de conexões JMS
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");

		// Fila
		final Queue queue = (Queue) ic.lookup("jms/pedidos");

		// Conexão JMS
		final Connection connection = factory.createConnection();

		// Sessão JMS
		final Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		
		// Receptor de mensagens
		final MessageConsumer receiver = session.createConsumer(queue);
		
		
		// Inicializa conexão
		connection.start();
		
		// recebendo
		final TextMessage message = (TextMessage) receiver.receive();

		System.out.println(message.getText());
		
		// fechando
		receiver.close();
		session.close();
		connection.close();
		
		System.out.println("FIM");
		System.exit(0);

	}

}
