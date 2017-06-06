/**
 * 
 */
package finCo.operation;

import finCo.model.Customer;
import finCo.model.IAccount;
import finCo.model.IEntry;
import finCo.model.IOrganization;

/**
 * composite
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public class Organization extends Customer implements IOrganization{
	
	private String numOfEmpl = "";
	
	public String getNumOfEmpl() {
		return numOfEmpl;
	}

	public void setNumOfEmpl(String numOfEmpl2) {
		this.numOfEmpl = numOfEmpl2;
	}


	@Override
	public String getType() {
		return "Organization";
	}

	@Override
	public void sendEmail(IAccount account,IEntry entry) {
		System.out.println("Operation: " + entry.getOperation() + " Amount: " + entry.getAmount() + " Balance: " + account.getBalance());
		System.out.println("Email has been sent to: " + this.getEmail());
	}



	
}
