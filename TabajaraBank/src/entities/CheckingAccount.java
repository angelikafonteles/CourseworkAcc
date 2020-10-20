package entities;

import entities.enums.AccountType;

public final class CheckingAccount extends Account{
	
	private static double fee = 2.0;

	public CheckingAccount() {
		super();
	}	
	
	public CheckingAccount(int number, String holder, double balance, AccountType type, double withdrawLimit,
			String passcode) {
		super(number, holder, balance, type, withdrawLimit, passcode);
	}

	@Override
	public void withdraw(double amount, double withdrawLimit, String passcode) {
		super.withdraw(amount, withdrawLimit, passcode);
		balance -= fee;
	}
}
