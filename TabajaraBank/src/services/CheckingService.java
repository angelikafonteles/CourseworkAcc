package services;

public class CheckingService {
	
	private TaxService taxService;

	public CheckingService(TaxService taxService) {
		this.taxService = taxService;
	}

	public TaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public double processTax(double amount) {
		
		return taxService.tax(amount);
	}

}
