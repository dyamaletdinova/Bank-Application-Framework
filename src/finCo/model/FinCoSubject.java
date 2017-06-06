/**
 * 
 */
package finCo.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana Yamaletdinova
 * Feb 8, 2017
 */
public abstract class FinCoSubject<T> {

	 protected List<T> observers = new ArrayList<T>();
	 
	 public void attach(T fco) {
		 observers.add(fco);
	 }
	 
	 public void detach(T fco) {
		 observers.remove(fco);
	 }
	 
	 public abstract void notifyAllObservers();
}
