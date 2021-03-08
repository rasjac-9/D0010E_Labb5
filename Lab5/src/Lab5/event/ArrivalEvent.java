
package Lab5.event;

import Lab5.simulation.State;
import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

/**
 * Adds a customer arriving to the supermarket if the store is not full. Added
 * customer is connected to a pick event and added to the queue.
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */

public class ArrivalEvent extends Event {

	Pick pickEvent;
	double time;
	Customer customer;



	public Arrival(State state, EventQueue eventList, double time) {
	   super(state, eventList);
	   this.time = time;
   
	} public ArrivalEvent(int ID, State s) {
		customerID = ID;
		time = ((SuperMarket) s).ts.getArrivalTime();

		effect();
	}

	public void doMe() {

		state.update(this);

		this.state.getSuperMarket().addCustomer(customer);

		if (customer.getState() == CustomerState.inSuperMarket) {
			double pickTime = this.time + state.getPickTime().next();
			pickEvent = new Pick(this.state, this.eventList, customer, pickTime);
			eventList.addEvent(pickEvent);
		}
		
	} @SuppressWarnings("unused")
	public void effect() {
		try {
			((SuperMarket) s).addCustomer();
			
			PickEvent pick = new PickEvent(customerID, (SuperMarket) s);
			ArrivalEvent arrival = new ArrivalEvent(customerID + 1, (SuperMarket) s);
			
		} catch(ArithmeticException e) {
			((SuperMarket) s).lostCustomer();
			ArrivalEvent arrival = new ArrivalEvent(customerID, (SuperMarket) s);
		}
		
	}

	public double getTime() {
		return time;
	}

	public String getName() {
		return "Arrival";
	}

	@Override
	public Customer getCustomer() {
		return customer;
	} public int getCustomer() {
		return customerID;
	}
}
