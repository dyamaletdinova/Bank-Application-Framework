/**
 * 
 */
package bank.model;

import bank.factory.BankCompanyAccountFactory;
import bank.factory.BankPersonalAccountFactory;
import finCo.model.FinCo;
import finCo.model.FinCoObserver;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class Bank extends FinCo implements FinCoObserver {

	
	public Bank() {
		super(new BankPersonalAccountFactory(), new BankCompanyAccountFactory());
	}
}
