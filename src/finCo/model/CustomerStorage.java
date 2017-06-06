/**
 * 
 */
package finCo.model;

import java.util.HashMap;

/**
 *
 * @author Diana Yamaletdinova Feb 7, 2017
 */
public class CustomerStorage {
	private HashMap<String,ICustomer> customerList;

	public CustomerStorage() {
		this.customerList = new HashMap<>();
	}

	public HashMap<String,ICustomer> getAllCustomers() {
		return customerList;
	}

	public void setCustomerList(HashMap<String, ICustomer> customerList) {
		this.customerList = customerList;
	}
	
	public ICustomer getCustomer(String name){
		return customerList.get(name);
	
	}
	
	public void addCustomer(String name, Customer customer){
		customerList.put(name, customer);
	}

}