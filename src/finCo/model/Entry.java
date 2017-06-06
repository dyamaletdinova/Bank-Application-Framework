/**
 * 
 */
package finCo.model;
import java.time.LocalDate;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 3, 2017
 */
public class Entry implements IEntry{
	private double amount;
	private LocalDate date;
	private String operation;
	
	public Entry(double amount, LocalDate todayDate, String operation) {
		this.amount = amount;
		this.date = todayDate;
		this.operation = operation;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String getOperation() {
		return operation;
	}
	
}
