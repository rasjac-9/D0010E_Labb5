
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.simulation.State;
import Lab5.state.SuperMarket;

/**
 * Stops the simulation
 *
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class StopEvent extends Event {

	/**
	 * Checks if the simulation shall end
	 * 
	 * @param state - the SuperMarket
	 * @param eq    - the EventQueue
	 */
	public EventQueue eq;
	StopEvent(State state, EventQueue eq, double time) {
		this.time = time; 
		this.EventQueue = eq;
		s = state;
	}
	/**
	 * Checks if the store is open and the event is named stop.
	 * if true it closes the store. otherwise it puts the event back
	 * in the queue.
	 */
	public void effect() {
		((SuperMarket) s).stopUpdate(this);
		if (!((SuperMarket) s).getOpenForBis() && EventQueue.getEvent().getName() == "Stop") {
			s.stop = true;
		} else {
			EventQueue.addEvent(this);
		}
	}
	/**
	 * returns the string Stop
	 */
	public String getName() { return "Stop"; }
}
