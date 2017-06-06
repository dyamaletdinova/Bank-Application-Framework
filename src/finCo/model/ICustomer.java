/**
 * 
 */
package finCo.model;


/**
 * Component
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public interface ICustomer {
	public void addAccount(IAccount newAccount);
	public void deleteAccount(IAccount newAccount);
	public void sendEmail(IAccount account, IEntry entry);
}
