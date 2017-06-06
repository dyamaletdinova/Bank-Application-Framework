/**
 * 
 */
package finCo.model;

import finCo.enums.CustomerType;

/**
 *
 * @author Diana Yamaletdinova Feb 7, 2017
 */
public class ClientData {

	public String accountType;
	public String accNum;
	public String name;
	public String street;
	public String city;
	public String state;
	public String zip;
	public String email;
	public CustomerType custType;
	public String amountDeposit;
	public String birthdate;
	public String numOfEmpl;
	public String expDate;

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public ClientData() {
	}

	public ClientData(String accountType, String accNum, String name, String street, String city, String state,
			String zip, String email, CustomerType type, String amountDeposit, String birthdate, String numOfEmpl) {
		super();
		this.accountType = accountType;
		this.accNum = accNum;
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.custType = type;
		this.amountDeposit = amountDeposit;
		this.birthdate = birthdate;
		this.numOfEmpl = numOfEmpl;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerType getCustType() {
		return custType;
	}

	public void setCustType(CustomerType custType) {
		this.custType = custType;
	}

	public String getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmountDeposit(String amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getNumOfEmpl() {
		return numOfEmpl;
	}

	public void setNumOfEmpl(String numOfEmpl) {
		this.numOfEmpl = numOfEmpl;
	}

}
