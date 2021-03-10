
package Lab5.simulation;

import Lab5.event.*;

/**
 * A abstract Event
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
public class Event {
	
	public double time;
	public int customerID;
	public State s;
	public EventQueue EventQueue;
	
	public Event(){
	}
	
	public void effect() {
		
	}

	public void effect(double t) {
		
	}

	public void addToEvent() {
	}

	public String getName() {
		return "event";
	}
}
