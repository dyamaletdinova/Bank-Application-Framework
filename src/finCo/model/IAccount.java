/**
 * 
 */
package finCo.model;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 1, 2017
 */
public interface IAccount {
	public void addEntry(IEntry entry);
	public double getBalance();
	public void setBalance(double balance);
	public void addInterest();
	public double getInterestRate();
	public String getType();
	public ICustomer getCustomer();
	public String getReportOutPut();
}
