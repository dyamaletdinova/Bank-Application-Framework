/**
 * 
 */
package finCo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 4, 2017
 */
public class Account implements IAccount {


	private List<IEntry> entryList;
	private ICustomer customer; 
	private double balance;
	private String accNum = "";
	

	public Account(Customer customer, String accNum) {
		this.entryList = new ArrayList<>();	
		this.customer = customer;
		this.accNum = accNum;
	}
	
	public List<IEntry> getEntryList() {
		return entryList;
	}
	
	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	
	@Override
	public void addEntry(IEntry entry) {
		
		//add entry to list of entries
		entryList.add(entry);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void addInterest() {
		 double rate = this.getInterestRate();
	     double interest = this.balance * rate;
	     this.balance = this.balance + interest;
	     System.out.println("Interest added "+ balance);
	}

	@Override
	public double getInterestRate() {
		return 0.1;
	}

	@Override
	public String getType() {
		return "Default account";
	}

	@Override
	public String getReportOutPut() {
		return "\nAccount Type: " + this.getType()
				+ "\nAccount Num:" + this.getAccNum()
				+ "\nBalance :" + this.getBalance();		
	}
	
	
}
