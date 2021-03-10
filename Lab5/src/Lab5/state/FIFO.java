
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
    public int queueCounter = 0;
	/**
	 * Adds a event to the event list
	 * 
	 * @param e - Event
	 */
	public void addToFIFO(Event e) {
		cashQueue.add(e);
		queueCounter++;
	}

	/**
	 * Removes the first event in the list throws exception if list is empty
	 * 
	 * @throws NoSuchElementException
	 */
	public void removeFirst() throws NoSuchElementException{
		if (getSize() > 0) {
			cashQueue.remove(0);
		} else {
			throw new NoSuchElementException();
		}
	}
	public int totalQueue() {
		return queueCounter; 
	}
	/**
	 * @return - true/false depending if the list is empty or not
	 */
	public boolean isEmpty() {
		if (getSize() == 0) {
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


	public int getSize() { return cashQueue.size();}

	public ArrayList getQue() {
		ArrayList<Integer> customerList = new ArrayList<>();
		for(int i = 0; i < cashQueue.size(); i++) {
			customerList.add(cashQueue.get(i).getCustomerID());
		}
		return customerList;
	}
}