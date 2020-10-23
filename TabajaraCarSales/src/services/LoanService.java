package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class LoanService {
	
	private static final double MONTHLY_INTEREST = 0.0189;

	public LoanService() {
	}
	
	public double loan(double amount, int months) {
		return amount * MONTHLY_INTEREST * months;
	}
	
	public void processLoan(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			 Date date = addMonths(contract.getDate(), i);
			 double updatedQuota = basicQuota + loan(basicQuota, i);
			 contract.addInstallment(new Installment(date, updatedQuota));
		}
	}
	
	private Date addMonths(Date date , int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
