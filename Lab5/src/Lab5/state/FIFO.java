/**
 * Description
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
package Lab5.state;

import java.util.ArrayList;

import Lab5.simulation.*;
import Lab5.state.*;
import jdk.jfr.Event;


import java.util.NoSuchElementException;

public class FIFO {
	private ArrayList<Lab5.simulation.Event> cashQueue = new ArrayList<Lab5.simulation.Event>();

	public void addToFIFO(Event e) {

	}

	public void queueFIFO() {
		
	}

	public void removeFirst() {
		if (cashQueue.size() > 0) {
			cashQueue.remove(0);
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean isEmpty() {
	if(cashQueue.size() == 0) {
		return true;
	} else {
		return false;
	}
}

}
