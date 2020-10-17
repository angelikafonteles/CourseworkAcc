package entities;

import entities.enums.AccountType;

public final class BusinessAccount extends Account {

	private double loanLimit;
	
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(int number, String holder, double balance, AccountType type, double withdrawLimit,
			double loanLimit) {
		super(number, holder, balance, type, withdrawLimit);
		this.loanLimit = loanLimit;
	}

	public double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount;
		}
	}
	
}
