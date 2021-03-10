
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

	public void effect() {
		((SuperMarket) s).viewUpdate(this);
		if (!((SuperMarket) s).getOpenForBis() && EventQueue.getEvent().getName() == "Stop") {
			s.stop = true;
		} else {
			EventQueue.addEvent(this);
		}
	}

	public String getName() { return "Stop"; }
}
