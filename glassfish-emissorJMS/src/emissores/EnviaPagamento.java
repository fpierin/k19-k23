package emissores;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class EnviaPagamento {
	
	public void envia(final String mensagem) throws Exception {
		final InitialContext ic = new InitialContext();
		final ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/K19Factory");
		final Queue topic = (Queue) ic.lookup("jms/pagamentos");
		final Connection connection = factory.createConnection();
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		final MessageProducer sender = session.createProducer(topic);
		final TextMessage message = session.createTextMessage();
		message.setText(mensagem + System.currentTimeMillis());
		sender.send(message);
		sender.close();
		session.close();
		connection.close();		
	}

	public static void main(final String[] args) throws Exception {
		System.out.println("Pronto!");
		final Scanner entrada = new Scanner(System.in);
		final String linha = entrada.nextLine();
		final EnviaPagamento pagamento = new EnviaPagamento();
		pagamento.envia(linha);
		System.out.println("Mensagem enviada");
		entrada.close();
		System.exit(0);
	}

}
