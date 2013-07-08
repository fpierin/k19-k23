package webservices;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class Math {

	public double add(final double v1, final double v2) {
		return v1 + v2;
	}
	
	public double subtract(final double v1, final double v2) {
		return v1 - v2;
	}
	
	public double multiply(final double v1, final double v2) {
		return v1 * v2;
	}	
	
	public double divide(final double v1, final double v2) {
		return v1 / v2;
	}	
	
}
