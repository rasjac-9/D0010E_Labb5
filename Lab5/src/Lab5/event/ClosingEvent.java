
package Lab5.event;

import Lab5.simulation.State;
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

	private double time;

	// if it shall be added to EventQueue when we run the program
	public ClosingEvent(SuperMarket sm, double t) {
		s = sm;
		time = t;
		effect();
	}

	public void effect() {
		// TODO: add to eventQueue

		((SuperMarket) s).closeStore();
	}

	public double getTime() {
		return time;
	}

	public String getName() {
		return "Close";
	}

	public Object getCustomer() {
		return null;
	}
}
