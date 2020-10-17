package entities;

import entities.enums.AccountType;
import entities.exceptions.DomainException;

public class Account {
	
	private int number;
	private String holder;
	protected double balance;
	private AccountType type;
	private double withdrawLimit;
	
	public Account() {
	}
	
	public Account(int number, String holder, double balance, AccountType type, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.type = type;	
		this.withdrawLimit = withdrawLimit;
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount, double withdrawLimit) {
		if (amount > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
		if (amount > balance) {
			throw new DomainException("Insuficient balance");
		}
		balance -= amount;
	}
	
	public String toString() {
		return "Account "
				+ number
				+ "\nHolder: "
				+ holder
				+ "\nAccount Type: "
				+ type
				+ "\nBalance: $"
				+ String.format("%.2f", balance);
	}

}
