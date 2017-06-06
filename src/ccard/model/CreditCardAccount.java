/**
 * 
 */
package ccard.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import finCo.model.Account;
import finCo.model.AccountStorage;
import finCo.model.Customer;
import finCo.model.IAccount;
import finCo.model.IEntry;

/**
 *
 * @author Diana Yamaletdinova Feb 6, 2017
 */
public abstract class CreditCardAccount extends Account implements IAccount {

	private String accNum;
	private AccountStorage accountStorage = AccountStorage.getInstance();

	public CreditCardAccount(Customer customer, String accNum) {
		super(customer, accNum);
		this.accNum = accNum;
	}

	public double getCurrentBalance() {

		Account acc = (Account) accountStorage.getAccount(accNum);
		System.out.println("\n\n\n getCurrentBalance-----------------" + acc.getBalance());

		return acc.getBalance();

	}

	public double getLastMonthBalance() {

		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();

		int currMonth = date.getMonth().getValue();

		Account acc = (Account) accountStorage.getAccount(accNum);

		double balance = acc.getBalance();

		for (IEntry entry : acc.getEntryList()) {
			if (entry.getDate().getMonth().getValue() == currMonth) {
				balance = balance - entry.getAmount();
			}
		}
		System.out.println("\n\n\n getLastMonthBalance-----------------" + balance);

		return balance;
	}

	public double getTotalMonthlyCharges() {

		double charge = 0;
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();
		int month = date.getMonth().getValue();

		Account acc = (Account) accountStorage.getAccount(accNum);

		for (IEntry entry : acc.getEntryList()) {
			if (entry.getOperation().equals("Charge")) {
				if (entry.getDate().getMonth().getValue() == month) {
					if (entry.getAmount() < 0) {
						charge = charge - entry.getAmount();
					}
				}
			}
		}

		System.out.println("\n\n\n getTotalMonthlyCharges-----------------" + charge);
		return charge;
	}

	public double getTotalMonthlyCredit() {
		
		double charge = 0;
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();
		
		int month = date.getMonth().getValue();

		Account acc = (Account) accountStorage.getAccount(accNum);
		
		for (IEntry entry : acc.getEntryList()) {
			if (entry.getOperation().equals("Deposit")){
				if (entry.getDate().getMonth().getValue() == month) {
					if (entry.getAmount() > 0) {
							charge = charge + entry.getAmount();
					}
				}
			}
		}
		System.out.println("\n\n\n getTotalMonthlyCredit-----------------" + charge);

		return charge;
	}

	@Override
	public String getType() {
		return "Credit card";
	}

	@Override
	public String getReportOutPut() {
		return "\nAccount Type: " + this.getType() + "\nAccount Num:" + this.getAccNum() + "\nBalance :"
				+ this.getBalance();
	}

	public abstract double getNewMonthlyBalance();

	public abstract double getMonthlyAmountDue();
}
