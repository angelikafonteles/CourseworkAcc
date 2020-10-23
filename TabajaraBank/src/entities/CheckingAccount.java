package entities;

import entities.enums.AccountType;
import services.CheckingService;

public final class CheckingAccount extends Account{

	private static double fee = 2.0;
	
	private CheckingService checkingService;

	public CheckingAccount() {
		super();
	}

	public CheckingAccount(int number, String holder, double balance, AccountType type, double withdrawLimit,
			String passcode, CheckingService checkingService) {
		super(number, holder, balance, type, withdrawLimit, passcode);
		this.checkingService = checkingService;
	}

	public CheckingService getCheckingService() {
		return checkingService;
	}

	public void setCheckingService(CheckingService checkingService) {
		this.checkingService = checkingService;
	}

	@Override
	public void withdraw(double amount, double withdrawLimit, String passcode) {
		super.withdraw(amount, withdrawLimit, passcode);
		balance -= (fee + checkingService.processTax(balance));
	}

}
