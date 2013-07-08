package br.com.k19.mdbs;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/topic/noticias"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") })
public class TratadorDeMensagensMDB implements MessageListener {

	@Override
	public void onMessage(final Message message) {
		try {
			TextMessage msg = (TextMessage) message;
			System.out.println(msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
			System.out.println("erro ");
		}

	}

}
