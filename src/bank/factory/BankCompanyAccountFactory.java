/**
 * 
 */
package bank.factory;

import bank.enums.BankAccountType;
import bank.model.Checking;
import bank.model.Savings;
import finCo.factory.CompanyAccountFactory;
import finCo.model.Account;
import finCo.model.ClientData;
import finCo.model.Customer;

/**
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class BankCompanyAccountFactory extends CompanyAccountFactory {
	
	@Override
	public Account createAccount(Customer customer, ClientData cd) {
		if (cd.accountType.equalsIgnoreCase(BankAccountType.CHECKING.getValue())){
			return new Checking(customer, cd.accNum);
		}else if (cd.accountType.equalsIgnoreCase(BankAccountType.SAVINGS.getValue())){
			return new Savings(customer, cd.accNum);
		}
		return null;
	}
}
