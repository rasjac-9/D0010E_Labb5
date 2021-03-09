
package Lab5.state;

import java.util.ArrayList;

import Lab5.simulation.Event;
// TODO: perhaps remove state?
import Lab5.state.*;
import Lab5.event.*;

import java.util.NoSuchElementException;

/**
 * The queue to the cash registers 
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
public class FIFO {
	private ArrayList<Event> cashQueue = new ArrayList<Event>();

	public void addToFIFO(Event e) {
		cashQueue.add(e);
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
		if (cashQueue.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Event getFirst() {
		return cashQueue.get(0);
	}

}
