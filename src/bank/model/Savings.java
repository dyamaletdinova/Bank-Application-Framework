/**
 * 
 */
package bank.model;

import finCo.model.Account;
import finCo.model.Customer;
import finCo.model.IAccount;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public class Savings extends Account implements IAccount{

	public Savings(Customer customer, String accNum) {
		super(customer, accNum);
	}
	
	@Override
    public double getInterestRate() {
        return 0.0325;
    }
    
	@Override
	public void addInterest() {
		 double balance = this.getBalance();
		 double rate = this.getInterestRate();
	     double interest = balance * rate;	    
	     balance = balance + interest;
	     System.out.println("Interest is "+ interest);
	     System.out.println("Interest added "+ balance);
	}

	@Override
	public String getReportOutPut() {
		return "\nAccount Type: " + this.getType()
				+ "\nAccount Num:" + this.getAccNum()
				+ "\nBalance :" + this.getBalance();		
	}
	
	@Override
	public String getType() {
		return "Savings";
	}
}
