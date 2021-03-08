
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

/**
 * Description
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class PickEvent extends Event{
	
	public PickEvent(int ID, SuperMarket sm) {
		customerID = ID;
		s = sm;
		time = s.ts.getPickTime();
	}
}
