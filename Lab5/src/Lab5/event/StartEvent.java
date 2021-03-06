
package Lab5.event;

import Lab5.RunConfig;
import Lab5.simulation.View;
import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

/**
 * Starts the SuperMarket
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class StartEvent extends Event{
	
	View view;

	public StartEvent(EventQueue eq, RunConfig rc) {
		s = new SuperMarket(rc);
		EventQueue = eq;
		
		EventQueue.addEvent(new ArrivalEvent(0, (SuperMarket) s, EventQueue));

		// view in StartEvent (?)
		view = new View();
	}
}
