package ccard.factory;

import ccard.enums.CCardType;
import ccard.model.Bronze;
import ccard.model.Gold;
import ccard.model.Silver;
import finCo.factory.PersonalAccountFactory;
import finCo.model.Account;
import finCo.model.ClientData;
import finCo.model.Customer;

public class CCardPersonalAccountFactory extends PersonalAccountFactory {

	@Override
	public Account createAccount(Customer customer, ClientData cd) {
		if (cd.getAccountType() == CCardType.GOLD.toString())
			return new Gold(customer, cd.accNum);
		else if (cd.getAccountType() == CCardType.SILVER.toString())
			return new Silver(customer, cd.accNum);

		return new Bronze(customer, cd.accNum);
	}

}
