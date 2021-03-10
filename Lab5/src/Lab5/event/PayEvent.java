
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

import java.util.NoSuchElementException;

/**
 * PayEvent customer pays for his/her items
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class PayEvent extends Event {
	
	
	PayEvent(int ID, SuperMarket superMarket) {
		customerID = ID;
		time = superMarket.ts.getPayTime();
		s = superMarket;

	}

	/**
	 * Removes customer from store and checks if cash queue is empty
	 */
	public void effect() {
		((SuperMarket) s).viewUpdate(this);
		((SuperMarket) s).customerLeft();

		if (!((SuperMarket) s).cashQueue.isEmpty()) {
			try {
				((SuperMarket) s).cashQueue.getFirst().effect(time);
				((SuperMarket) s).cashQueue.removeFirst();
			} catch (NoSuchElementException e) {
				// TODO: make error msg?
			}
		}
	}

	/**
	 * @return - int whit customerID
	 */
	public int getCustomer() {
		return customerID;
	}

	public String getName() { return "Betalning"; }
}
