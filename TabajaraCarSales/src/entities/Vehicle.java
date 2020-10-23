package entities;

import entities.enums.VehicleType;
import entities.exceptions.DomainException;

public class Vehicle {
	
	private String model;
	private VehicleType type;
	protected Double price;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String model, VehicleType type, Double price) {
		super();
		this.model = model;
		this.type = type;
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getModelo() {
		return model;
	}

	public void setModelo(String model) {
		this.model = model;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}
	
	public void ProcessDiscount(double amount) {
		price -= (amount * 0.10);
	}

	@Override
	public String toString() {
		return "Modelo: "
				+ model
				+ "\nTipo: "
				+ type
				+ "\nPreço: R$ "
				+ String.format("%.2f", price);
	}
	
	

}
