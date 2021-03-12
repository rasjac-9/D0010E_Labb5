package Lab5.simulation;

import Lab5.event.EventQueue;

import java.util.Observable;

/**
 * Creates a abstract state
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class State extends Observable {
	public boolean stop = false;
	public double currentTime = 0;
	public EventQueue eventQueue;
	public View view;
	public int LostCustomer;
	public int getLostCustomer() {
		return LostCustomer;
	}
}
