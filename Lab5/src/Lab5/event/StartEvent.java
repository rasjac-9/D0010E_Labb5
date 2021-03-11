
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
	RunConfig rc;
	public StartEvent(EventQueue eq, RunConfig rc) {

		this.EventQueue = eq;
		s = new SuperMarket(rc, eq);
		this.rc = rc;
	}
	/**
	 * Starts up the simulation by creating a 
	 * arrival event, then adds the closing and stop events to the queue.
	 */
	public void effect() {
		((SuperMarket) s).viewUpdate(this);
		EventQueue.addEvent(new ArrivalEvent(0, s, EventQueue));
		EventQueue.addEvent(new ClosingEvent(((SuperMarket) s), rc.closingTime));
		EventQueue.addEvent(new StopEvent(s, EventQueue,999));
	}
	/**
	 * returns the string "Start"
	 */
	public String getName() { return "Start"; }
}
