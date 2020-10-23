package services;

public class IPIService implements TaxService{
	
	@Override
	public double tax(double amount) {
		return amount * 0.15;
	}
}
