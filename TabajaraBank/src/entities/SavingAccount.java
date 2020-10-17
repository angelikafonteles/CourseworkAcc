package entities;

import entities.enums.AccountType;

public final class SavingAccount extends Account {

	private double interestRate;
	
	public SavingAccount() {
	}

	public SavingAccount(int number, String holder, double balance, AccountType type, double withdrawLimit,
			double interestRate) {
		super(number, holder, balance, type, withdrawLimit);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void updateBalance() {
		balance += balance * interestRate / 100.0;

	}

}
