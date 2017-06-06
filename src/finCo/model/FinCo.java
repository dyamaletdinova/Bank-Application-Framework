/**
 * 
 */
package finCo.model;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import finCo.controller.AccountController;
import finCo.controller.OperationController;
import finCo.controller.ReportGeneratorController;
import finCo.factory.CompanyAccountFactory;
import finCo.factory.FinCoFactory;
import finCo.factory.PersonalAccountFactory;
import finCo.operation.AddInterest;
import finCo.operation.CreateAccount;
import finCo.operation.PrintReport;

/**
 * 
 * @author Diana Yamaletdinova
 * Feb 6, 2017
 */
public class FinCo implements FinCoObserver{
	
	private OperationController operationController = OperationController.getInstance();
	
	private CreateAccount createAccount;
	private Transaction transaction;
	private AddInterest addInterest;
	private PrintReport report;
	FinCoFactory personalFactory;
	FinCoFactory companyFactory;
	private Document document;

	public FinCo (PersonalAccountFactory personalAccountFactory, CompanyAccountFactory companyAccountFactory){
		this.personalFactory = personalAccountFactory;
		this.companyFactory = companyAccountFactory;
		AccountController.getInstance().setFinco(this);
		ReportGeneratorController.getInstance().attach(this);
	}

	public FinCo(){
		this(new PersonalAccountFactory(),new CompanyAccountFactory());
	}

	public FinCoFactory getPersonalFactory() {
		return personalFactory;
	}

	public FinCoFactory getCompanyFactory() {
		return companyFactory;
	}

	public void addAccount(ClientData cd){
		createAccount = new CreateAccount (cd);
		operationController.submit(createAccount);
	}
	public void doTransaction (String accNo, double amount, String operation){
		transaction = new Transaction(accNo, amount, operation);
		operationController.submit(transaction);
	}

	public void printReport (){
		report = new PrintReport();
		operationController.submit(report);
	}
	
	public void addInterest(){
		addInterest = new AddInterest();
		operationController.submit(addInterest);
	}

	public IAccount getAccount(String accNo) {
		return AccountStorage.getInstance().getAccount(accNo);
	}

	@Override
	public void update(String s) {
		
		if ( document != null ) {
			try {
				document.insertString(0, s, null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
//		System.out.println("Calling update.... on CCard" + s);
	}
	public void setReportReciever(Document document) {
		this.document = document;
	}
}
