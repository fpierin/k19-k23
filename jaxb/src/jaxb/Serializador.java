package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Serializador {

	public static void main(final String[] args) throws JAXBException {
		final JAXBContext context = JAXBContext.newInstance(Conta.class);
		final Marshaller marshaller = context.createMarshaller();
		
		final Conta conta = new Conta();
		conta.setLimite(2000);
		conta.setSaldo(1000);
		
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(conta, new File("conta.xml"));

	}

}
