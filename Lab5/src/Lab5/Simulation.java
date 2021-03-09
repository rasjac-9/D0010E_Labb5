
package Lab5;

import Lab5.simulation.Event;
import Lab5.event.EventQueue;
import Lab5.event.StartEvent;

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
	public EventQueue eq = new EventQueue();
	public RunConfig rc = new RunConfig();
	
	public Event start = new StartEvent(eq, rc);
}
