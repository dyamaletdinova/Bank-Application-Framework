/**
 * 
 */
package finCo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public abstract class Customer implements ICustomer{
	
	private String name; 
	private String email;
	private Address address;
	List<IAccount> accountList;
	
	public Customer(){
		this.address = new Address();
		this.accountList = new ArrayList<>();
	}
	
	public abstract String getType();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
    public void addAccount(IAccount account) {
		accountList.add(account);
    }

    @Override
    public void deleteAccount(IAccount account) {
    	accountList.remove(account);
    }

	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}

}
