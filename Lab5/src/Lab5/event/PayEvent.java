
package Lab5.event;

import java.util.NoSuchElementException;

import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

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

	public void effect() {
		((SuperMarket) s).customerLeft();

		if (!((SuperMarket) s).cashQueue.isEmpty()) {
			try {
				((SuperMarket) s).cashQueue.getFirst().effect();
				((SuperMarket) s).cashQueue.removeFirst();			
			}catch(NoSuchElementException e) {
				// TODO: make error msg?
			}
		}
	}
	
	public int getCustomer() {
		return customerID;
	}
}
