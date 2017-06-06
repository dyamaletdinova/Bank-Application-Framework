/**
 * 
 */
package finCo.factory;

import finCo.model.Account;
import finCo.model.ClientData;
import finCo.model.Customer;
import finCo.model.ICustomer;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 4, 2017
 */
public abstract class FinCoFactory {
	public abstract Account createAccount(Customer customer, ClientData cd);
	public abstract ICustomer createCustomer();
}
