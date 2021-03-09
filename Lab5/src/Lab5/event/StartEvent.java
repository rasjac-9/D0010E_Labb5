
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
	SuperMarket superMarket;
	View view;

	public StartEvent(EventQueue eq, RunConfig rc) {
		superMarket = new SuperMarket(rc);
		EventQueue = eq;
		
		// EventQue variable not added to superMarket yet
		EventQueue.addEvent(new ArrivalEvent(0, superMarket, EventQueue));

		// view in StartEvent (?)
		view = new View();
	}
}
