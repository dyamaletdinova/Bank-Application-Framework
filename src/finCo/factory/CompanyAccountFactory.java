/**
 * 
 */
package finCo.factory;

import finCo.model.Account;
import finCo.model.ClientData;
import finCo.model.Customer;
import finCo.operation.Organization;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class CompanyAccountFactory extends FinCoFactory{


	@Override
	public Account createAccount(Customer customer, ClientData cd) {
//		if (cd.accountType.equalsIgnoreCase("Default account") ){
			return new Account(customer, cd.accNum);
//		}	
//		return null;
	}

	@Override
	public Customer createCustomer() {
		return new Organization();
	}


}
