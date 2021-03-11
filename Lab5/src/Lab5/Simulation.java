
package Lab5;

import Lab5.simulation.State;
import Lab5.simulation.Event;
import Lab5.event.*;

/**
 * Runs a simulation
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class Simulation {

	public EventQueue eq;
	public RunConfig rc;
	public Event start;
	public State s;

	public Simulation(String[] args) {
		eq = new EventQueue();
		rc = new RunConfig(args);

		start = new StartEvent(eq, rc);
		s = start.s;
		eq.addEvent(start);

		while (!s.stop) {
			if (!eq.isEmpty()) {
				eq.getEvent().effect();
				eq.removeEvent();
			}
		}
	}
}
