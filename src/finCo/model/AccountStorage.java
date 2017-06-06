/**
 * 
 */
package finCo.model;

import java.util.HashMap;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class AccountStorage {
	
	private static AccountStorage accountStorage;
	private HashMap<String,IAccount> accountList = new HashMap<>();	 
	
	private AccountStorage() {
	}

	public static AccountStorage getInstance() {
		
		if (accountStorage == null) {
			accountStorage = new AccountStorage();
		}
		return accountStorage;
	}
	
	public HashMap<String,IAccount> getAllAccounts() {
		return accountList;
	}

	public void setAccountList(HashMap<String,IAccount> accList) {
		this.accountList = accList;
	}

	public IAccount getAccount(String accNum) {
		//return accountList.get(0);//dummy code
		return accountList.get(accNum);
	}
	
	public void addAccount(String accNum, Account account){
		accountList.put(accNum, account);
	}

}
