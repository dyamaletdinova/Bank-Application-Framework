/**
 * 
 */
package finCo.operation;

import finCo.controller.AccountController;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class AddInterest implements Operation{

	private AccountController ac = AccountController.getInstance();

	@Override
	public void execute() {
		ac.addInterest();
	}


}
