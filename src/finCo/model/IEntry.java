/**
 * 
 */
package finCo.model;

import java.time.LocalDate;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 5, 2017
 */
public interface IEntry {
	LocalDate getDate();
	double getAmount();
	String getOperation();
}
