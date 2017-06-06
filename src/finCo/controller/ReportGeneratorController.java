/**
 * 
 */
package finCo.controller;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;

import finCo.model.AccountStorage;
import finCo.model.FinCoObserver;
import finCo.model.FinCoSubject;
import finCo.model.IAccount;
import finCo.model.IReport;

/**
 *
 * @author Diana Yamaletdinova Feb 6, 2017
 */
public class ReportGeneratorController extends FinCoSubject<FinCoObserver> implements IReport {

	private static ReportGeneratorController reportGeneratorController;
	private String finalReport;
	
	private ReportGeneratorController() {
	}

	public static ReportGeneratorController getInstance() {

		if (reportGeneratorController == null) {
			reportGeneratorController = new ReportGeneratorController();
		}
		return reportGeneratorController;
	}

	private AccountStorage accountStorage = AccountStorage.getInstance();

	@Override
	public void generateReport() {
		
		HashMap<String, IAccount> accounts = new HashMap<String, IAccount>();
		accounts = accountStorage.getAllAccounts();
		Iterator<Map.Entry<String, IAccount>> iterator = accounts.entrySet().iterator();
		StringBuffer str = new StringBuffer();
		while (iterator.hasNext()) {
			Map.Entry<String, IAccount> entry = iterator.next();
			str.append(entry.getValue().getReportOutPut() + "\n");
		}
		finalReport = str.toString();
		
		notifyAllObservers();	
	}

	@Override
	public void notifyAllObservers() {
		 for ( FinCoObserver fco: observers) {
			 fco.update(finalReport);
		 }
	}
}
