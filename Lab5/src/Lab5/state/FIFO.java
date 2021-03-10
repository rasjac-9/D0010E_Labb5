
package Lab5.state;

import java.util.ArrayList;

import Lab5.simulation.Event;
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

	/**
	 * Adds a event to the event list
	 * 
	 * @param e - Event
	 */
	public void addToFIFO(Event e) {
		cashQueue.add(e);
	}

	/**
	 * Removes the first event in the list throws exception if list is empty
	 * 
	 * @throws NoSuchElementException
	 */
	public void removeFirst() throws NoSuchElementException{
		if (cashQueue.size() > 0) {
			cashQueue.remove(0);
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * @return - true/false depending if the list is empty or not
	 */
	public boolean isEmpty() {
		if (cashQueue.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the first event in the list
	 * 
	 * @return Event
	 * @throws NoSuchElementException
	 */
	public Event getFirst() throws NoSuchElementException{
		if (cashQueue.size() > 0) {
			return cashQueue.get(0);
		} else {
			throw new NoSuchElementException();
		}

	}

	/**
	 * Returns the list in a String format
	 */
	public String toString() {
		String print = "[";
		for (int i = 0; i < cashQueue.size(); i++) {
			if (print.length() == 1) {
				print += String.valueOf(cashQueue.get(i).customerID);
			} else {
				print += "," + String.valueOf(cashQueue.get(i).customerID);
			}
		}
		print += "]";
		
		return print;
	}

	public int getSize() { return cashQueue.size();}

	public ArrayList getQue() { return cashQueue;}
}