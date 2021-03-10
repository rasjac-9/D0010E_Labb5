
package Lab5.event;

import Lab5.simulation.State;
import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

/**
 * Adds a customer arriving to the supermarket if the store is not full. Added
 * customer is connected to a pick event and added to the queue.
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class ArrivalEvent extends Event {

	/**
	 * Creates a arrival event
	 * 
	 * @param ID - customer id
	 * @param s  - the supermarket
	 */
	SuperMarket s;
	public ArrivalEvent(int ID, State s, EventQueue eq) {
		customerID = ID;
		EventQueue = eq;
		time = ((SuperMarket) s).ts.getArrivalTime();
		this.s = (SuperMarket) s;

		effect();
	}

	/**
	 * Checks if customer can enter the SuperMarket starts PickEvent and new
	 * ArrivalEvent if true
	 */
	public void effect() {
		((SuperMarket) s).viewUpdate(this);
		try {
			((SuperMarket) s).addCustomer();
			EventQueue.addEvent(new PickEvent(customerID, (SuperMarket) s, EventQueue));
			
			if(((SuperMarket) s).getOpenForBis()) {
				EventQueue.addEvent(new ArrivalEvent(customerID + 1, (SuperMarket) s, EventQueue));
			}
			
		} catch (ArithmeticException e) {
			((SuperMarket) s).lostCustomer();
			
			if(((SuperMarket) s).getOpenForBis()) {
				EventQueue.addEvent(new ArrivalEvent(customerID, (SuperMarket) s, EventQueue));
			}
		}

	}

	/**
	 * @return the time the event will happen
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @return - string whit event name
	 */
	public String getName() {
		return "Ankomst";
	}

	/**
	 * @return - customer ID
	 */
	public int getCustomer() {
		return customerID;
	}
}
