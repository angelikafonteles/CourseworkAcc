package entities;

import entities.enums.AccountType;

public class CheckingAccount extends Account{

	public CheckingAccount() {
		
	}

	public CheckingAccount(int number, String holder, double balance, AccountType type, double withdrawLimit) {
		super(number, holder, balance, type, withdrawLimit);
	}
	
	@Override
	public void withdraw(double amount, double withdrawLimit) {
		super.withdraw(amount, withdrawLimit);
		balance -= 2.0;
	}
}
