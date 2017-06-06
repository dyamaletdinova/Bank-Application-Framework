/**
 * 
 */
package finCo.operation;

import finCo.controller.AccountController;
import finCo.model.ClientData;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class CreateAccount implements Operation{
	
	private AccountController ac = AccountController.getInstance();
	private ClientData cd;
	
	public CreateAccount(ClientData cd) {	
		this.cd = cd;
	}

	@Override
	public void execute() {
		ac.addAccount(cd);
	}

}
