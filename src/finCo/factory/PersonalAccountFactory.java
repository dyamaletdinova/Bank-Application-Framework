/**
 * 
 */
package finCo.factory;

import finCo.model.Account;
import finCo.model.ClientData;
import finCo.model.Customer;
import finCo.model.Person;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class PersonalAccountFactory extends FinCoFactory{


	@Override
	public Account createAccount(Customer customer, ClientData cd) {
//		if (cd.accountType.equalsIgnoreCase("Default account")){
			return new Account(customer, cd.accNum);
//		}
//		return null;
	}

	@Override
	public Customer createCustomer() {
		return new Person();
	}

}
