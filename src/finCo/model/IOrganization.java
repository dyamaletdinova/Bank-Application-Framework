/**
 * 
 */
package finCo.model;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public interface IOrganization extends ICustomer{
	public void addAccount(IAccount newAccount);
	public void deleteAccount(IAccount newAccount);
}
