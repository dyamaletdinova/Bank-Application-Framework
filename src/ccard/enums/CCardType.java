/**
 * 
 */
package ccard.enums;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 7, 2017
 */
public enum CCardType {
		GOLD("GOLD"),
		SILVER("SILVER"),
		BRONZE("BRONZE");
	private String value;
	
	private CCardType(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
}
