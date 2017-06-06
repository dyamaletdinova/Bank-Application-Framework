/**
 * 
 */
package finCo.model;

import finCo.controller.AccountController;
import finCo.operation.Operation;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class Transaction implements Operation{
	String accNo;
	private double amount;
	private String operation;

	public Transaction (String acc, double a, String o){
		this.accNo = acc;
		this.amount = a;
		this.operation = o;
	}
	
	@Override
	public void execute() {
		AccountController accountController = AccountController.getInstance();
		accountController.doTransaction(accNo, amount, operation);
	}


}
