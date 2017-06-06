/**
 * 
 */
package ccard.model;

import finCo.model.Customer;

/**
 *
 * @author Diana Yamaletdinova Feb 6, 2017
 */
public class Gold extends CreditCardAccount {

	private double minimumPaymentRate = 0.10;

	public Gold(Customer customer, String accNum) {
		super(customer, accNum);
	}

	@Override
	public double getInterestRate() {
		return 0.06;
	}
	
	@Override
	public double getNewMonthlyBalance() {
		return 	this.getLastMonthBalance() 
				- this.getTotalMonthlyCredit()
				+ this.getTotalMonthlyCharges()
				+ this.getInterestRate() 
				* ( this.getLastMonthBalance() - this.getTotalMonthlyCredit() );
	}

	@Override
	public double getMonthlyAmountDue() {
		return this.getLastMonthBalance() * minimumPaymentRate;
	}

	@Override
	public String getReportOutPut() {
		super.getReportOutPut();
		StringBuilder output = new StringBuilder();
		String newLine = System.lineSeparator();

		output.append(newLine);
		output.append("Previous Balance :").append(this.getLastMonthBalance()).append(newLine);
		output.append("Total Charges :").append(this.getTotalMonthlyCharges()).append(newLine);
		output.append("Total Credits :").append(this.getTotalMonthlyCredit()).append(newLine);
		/*double balance = this.getLastMonthBalance() - this.getTotalMonthlyCredit()
				+ this.getTotalMonthlyCharges()
				+ +this.getInterestRate() * (this.getLastMonthBalance() - this.getTotalMonthlyCredit());*/
		output.append("New Balance :").append(this.getNewMonthlyBalance()).append(newLine);
		output.append("Due Amount :").append(this.getMonthlyAmountDue());
		output.append(newLine);

		return output.toString();
	}
	
	@Override
	public String getType() {
		return "Gold";
	}

}
