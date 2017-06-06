/**
 * 
 */
package finCo.model;

/**
 * leaf
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public class Person extends Customer implements IPerson{
	
	private String dateOfBirth;

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String getType() {
		return "Personal";
	}

	@Override
	public void sendEmail(IAccount account,IEntry entry) {
		if (account.getBalance() < 0 || entry.getAmount() > 400) {
			System.out.println("Operation: " + entry.getOperation() + " Amount: " + entry.getAmount() + " Balance: " + account.getBalance());
			System.out.println("Email has been sent to: " + this.getEmail());
		}
	}

	
}
