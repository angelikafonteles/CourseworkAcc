package services;

public class BrazilTaxService implements TaxService{
	
	public double tax(double amount) {
		if(amount <= 500.0) {
			return amount * 0.002;
		}
		else {
			return amount * 0.005;
		}
	}
}
