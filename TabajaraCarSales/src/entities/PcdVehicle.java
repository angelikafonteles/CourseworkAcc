package entities;

import entities.enums.VehicleType;

public class PcdVehicle extends Vehicle{
	
	public PcdVehicle() {
		super();
	}

	public PcdVehicle(String model, VehicleType type, Double price) {
		super(model, type, price);
	}
}
