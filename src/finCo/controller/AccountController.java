/**
 * 
 */
package finCo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import finCo.enums.CustomerType;
import finCo.factory.FinCoFactory;
import finCo.model.Account;
import finCo.model.AccountStorage;
import finCo.model.Address;
import finCo.model.ClientData;
import finCo.model.CustomerStorage;
import finCo.model.Entry;
import finCo.model.FinCo;
import finCo.model.IAccount;
import finCo.model.ICustomer;
import finCo.model.Person;
import finCo.operation.Operation;
import finCo.operation.Organization;

/**
 * @author Diana Yamaletdinova Feb 6, 2017
 */
public class AccountController {

	private static AccountController accountControllerObj;
	private AccountStorage accountStorage = AccountStorage.getInstance();
	private CustomerStorage customerStorage = new CustomerStorage();
	private FinCoFactory fincoFactory;
	private OperationController operationController = OperationController.getInstance();

	private FinCo finCo;

	private AccountController() {
	}

	public static AccountController getInstance() {

		if (accountControllerObj == null) {
			accountControllerObj = new AccountController();
		}
		return accountControllerObj;
	}

	public void doTransaction(String accNo, double amount, String operation) {
		// get the account
		IAccount account = this.accountStorage.getAccount(accNo);

		// get the current date
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate todayDate = currentTime.toLocalDate();

		// create a new entry obj
		Entry entry = new Entry(amount, todayDate, operation);

		account.addEntry(entry);

		// do amount = amount +amount;
		account.setBalance(account.getBalance() + amount);

		class Mailer implements Operation {

			@Override
			public void execute() {
				ICustomer customer = account.getCustomer();
				customer.sendEmail(account, entry);
			}
		}

		Operation mailer = new Mailer();
		operationController.submit(mailer);

	}

	public void addInterest() {
		HashMap<String, IAccount> accounts = new HashMap<String, IAccount>();
		accounts = accountStorage.getAllAccounts();
		Iterator<Map.Entry<String, IAccount>> iterator = accounts.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, IAccount> entry = iterator.next();
			entry.getValue().addInterest();
		}
	}

	public void addAccount(ClientData cd) {

		Address address = new Address();
		address.setStreet(cd.street);
		address.setCity(cd.city);
		address.setState(cd.state);
		address.setZip(cd.zip);
		
		// using the pull method we get the right factory based on the type of
		// the customer
		if (cd.custType.equals(CustomerType.ORGANIZATION)) {

			fincoFactory = this.finCo.getCompanyFactory();

			Organization organization = (Organization) fincoFactory.createCustomer();
			
			organization.setAddress(address);
			organization.setName(cd.name);
			organization.setEmail(cd.email);
			organization.setNumOfEmpl(cd.numOfEmpl);
			customerStorage.addCustomer(cd.name, organization);

			Account account = fincoFactory.createAccount(organization, cd);
			account.setAccNum(cd.accNum);
			account.setCustomer(organization);

			accountStorage.addAccount(cd.accNum, account);
			System.out.println(
					"Account for the '" + cd.custType + "' was created. The account type is " + cd.accountType);

		} else {
			fincoFactory = this.finCo.getPersonalFactory();
			// setting the customer
			Person person = (Person) fincoFactory.createCustomer();
			person.setAddress(address);
			person.setName(cd.name);
			person.setEmail(cd.email);		
			person.setDateOfBirth(cd.birthdate);
			customerStorage.addCustomer(cd.name, person);

			// setting the account
			Account account = (Account) fincoFactory.createAccount(person, cd);
			account.setAccNum(cd.accNum);
			account.setCustomer(person);

			accountStorage.addAccount(cd.accNum, account);

			System.out.println(
					"Account for the  '" + cd.custType + "'  was created. The account type is " + cd.accountType);
		}
	}

	public void setFinco(FinCo finCo) {
		this.finCo = finCo;

	}

}
