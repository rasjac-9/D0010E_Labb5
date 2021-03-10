
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

/**
 * Tells when the supermarket closes and does not let customers in the store.
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class ClosingEvent extends Event {

	public double time;

	// if it shall be added to EventQueue when we run the program
	public ClosingEvent(SuperMarket sm, double t) {
		s = sm;
		time = t;

	}

	/**
	 * Closes the store
	 */
	public void effect() {
		// TODO: add to eventQueue
		((SuperMarket) s).viewUpdate(this);  
		((SuperMarket) s).closeStore();
	}

	/**
	 * @return double when it will happen
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @return String event name
	 */
	public String getName() {
		return "Stänger";
	}

	/**
	 * @return null no customer
	 */
	public Object getCustomer() {
		return null;
	}
}
