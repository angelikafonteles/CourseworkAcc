package services;

public class SaleService {

	private TaxService taxService;
	
	public SaleService() {
	}
	
	public SaleService(TaxService taxService) {
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
