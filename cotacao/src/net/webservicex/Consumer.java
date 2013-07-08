package net.webservicex;

public class Consumer {

	public static void main(final String[] args) {
		final CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		final CurrencyConvertorSoap currencyConvertorSoap = currencyConvertor.getCurrencyConvertorSoap();
		final double conversionRate = currencyConvertorSoap.conversionRate(Currency.USD, Currency.BRL);
		System.out.println("Conversao --> " +conversionRate);
	}
	
}
