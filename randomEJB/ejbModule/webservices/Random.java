package webservices;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class Random {

	public double next(final double max) {
		return Math.random() * max;
	}
	
}
