
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.simulation.State;
import Lab5.state.SuperMarket;

/**
 * PickEvent customer picks his/her items
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class PickEvent extends Event {

	public PickEvent(int ID, State sm, EventQueue eq) {
		customerID = ID;  
		EventQueue = eq;
		s = sm;
		time = ((SuperMarket) s).ts.getPickTime();


	}

	/**
	 * If cash registers are available starts PayEvent else adds to FIFO queue
	 */
	public void effect() {
		try {
			((SuperMarket) s).addToCashReg();
			EventQueue.addEvent(new PayEvent(customerID, (SuperMarket) s));
		} catch (ArithmeticException e) {
			((SuperMarket) s).cashQueue.addToFIFO(this);
		}

		((SuperMarket) s).viewUpdate(this);
	}

	/**
	 * @return - int whit customer ID
	 */
	public int getCustomer() {
		return customerID;
	}

	public String getName() { return "Plock"; }
}
