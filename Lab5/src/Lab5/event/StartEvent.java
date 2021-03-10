
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
public class StartEvent extends Event {

	View view;

	/**
	 * Starts every thing
	 * 
	 * @param eq - the EventQueueu
	 * @param rc - the RunConfig
	 */
	public StartEvent(EventQueue eq, RunConfig rc) {
		((SuperMarket) s).viewUpdate(this);

		s = new SuperMarket(rc);
		EventQueue = eq;

		EventQueue.addEvent(new ArrivalEvent(0, s, EventQueue));
	}

	public String getName() { return "Start"; }
}
