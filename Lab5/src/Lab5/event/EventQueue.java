
package Lab5.event;

import Lab5.simulation.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Queues all event
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class EventQueue {
	private ArrayList<Event> eventList = new ArrayList<>();

	/**
	 * adds event to queue
	 * 
	 * @param event
	 */
	public void addEvent(Event event) {
		//System.out.println(event.getName()+ " " +event.time);
		eventList.add(event);
		sortEvent();
	}

	/**
	 * @return returns the first event
	 */
	public Event getEvent() {
		if (eventList.size() > 0) {
		return eventList.get(0);
	} else {
		throw new NoSuchElementException();
		}
	}
	/**
	 * Short the queue based on when the events are bound to happen
	 */
	public void sortEvent() {

		if (eventList.size() > 1) { // needs to hold more than 2 objects to sort

			/*
			 * e.g. arraylist [5,3,8,6] first loop: if (5 > 3) {swap place, [3,5,8,6]} if (5
			 * > 8) if (5 > 6) second loop: if (8 > 6) {swap place [3,5,6,8]}
			 */
			for (int i = 1; i < eventList.size(); i++) {
				for (int j = 0; j < eventList.size()-1; j++) {

					if (eventList.get(j).time > eventList.get(i).time) {
						Event eventIndexI = eventList.get(i);
						Event eventIndexJ = eventList.get(j);

						eventList.set(j, eventIndexI);
						eventList.set(i, eventIndexJ);
					}
				}
			}
		}
	}

	/**
	 * Removes the first object in the queue
	 */
	public void removeEvent() {
		eventList.remove(0);
		sortEvent();

	}
	
	/**
	 * @return true is queue is empty
	 */
	public boolean isEmpty() {
		if(eventList.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
