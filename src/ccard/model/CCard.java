package ccard.model;

import ccard.factory.CCardCompanyAccountFactory;
import ccard.factory.CCardPersonalAccountFactory;
import finCo.model.FinCo;
import finCo.model.FinCoObserver;

public class CCard extends FinCo implements FinCoObserver {

	
	public CCard() {
		super(new CCardPersonalAccountFactory(), new CCardCompanyAccountFactory());		
	}

}
