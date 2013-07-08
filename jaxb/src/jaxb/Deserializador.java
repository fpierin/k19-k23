package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Deserializador {

	public static void main(final String[] args) throws JAXBException {
		final JAXBContext context = JAXBContext.newInstance(Conta.class);
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		final Conta conta = (Conta) unmarshaller.unmarshal(new File("conta.xml"));
		System.out.println(conta);
	}

}
