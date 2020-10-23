package entities;

import entities.enums.VehicleType;
import services.SaleService;

public class StandardVehicle extends Vehicle{
	
	private SaleService saleService;
	
	public StandardVehicle() {
		super();
	}

	public StandardVehicle(String model, VehicleType type, double price, SaleService saleService) {
		super(model, type, price);
		this.saleService = saleService;
	}
	
	public SaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(SaleService saleService) {
		this.saleService = saleService;
	}
	
	public void updatePrice(double amount) {
		price += saleService.processTax(amount);
	}

}
