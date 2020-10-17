package application;

import entities.enums.AccountType;
import entities.exceptions.DomainException;

import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Program {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		Account account = new Account();
		SavingAccount sacc;
		BusinessAccount bacc;
		
		try {
			System.out.println("ENTER ACCOUNT DATA");
			System.out.print("Enter account number: ");
			int number = sc.nextInt();
			System.out.print("Which type of account (CHECKING/ SAVING/ BUSINESS)? ");
			sc.nextLine();
			AccountType accountType = AccountType.valueOf(sc.nextLine().toUpperCase());
			System.out.print("Enter account holder: ");
			String holder = sc.nextLine();
			System.out.print("Enter the initial deposit: ");
			double balance = sc.nextDouble();
			System.out.print("Enter the withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
		
			if(accountType.ordinal() == 0) {
				account = new Account(number, holder, balance, accountType, withdrawLimit);
			}
			else if(accountType.ordinal() == 1) {
				System.out.print("Interest Rate: ");
				double interestRate = sc.nextDouble();
				account = new SavingAccount(number, holder, balance, accountType, withdrawLimit, interestRate);
				sacc = (SavingAccount)account;
				sacc.updateBalance();
			}
			else if(accountType.ordinal() == 2) {
				System.out.print("Loan Limit: ");
				double loanLimit = sc.nextDouble();
				account = new BusinessAccount(number, holder, balance, accountType, withdrawLimit, loanLimit);
				bacc = (BusinessAccount)account;
				bacc.loan(loanLimit);
			}
		
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount, withdrawLimit);
			System.out.println(account);
		
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
