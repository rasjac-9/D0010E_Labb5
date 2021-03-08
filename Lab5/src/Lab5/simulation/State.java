package Lab5.simulation;

import Lab5.event.EventQueue;

/**
 * Creates a abstract state
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
public class State {
	boolean stop = false;
	public EventQueue eventQueue = new EventQueue();
}
