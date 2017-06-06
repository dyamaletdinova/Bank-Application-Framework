/**
 * 
 */
package bank.enums;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 7, 2017
 */
public enum BankAccountType {
		CHECKING ("Ch"),
		SAVINGS ("S");
	private String value;
	
	private BankAccountType(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
}
