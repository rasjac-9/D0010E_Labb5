package Lab5.event;

import State.State;

/**
 * Adds a customer arriving to the supermarket if the store is not full.
 * Added customer is connected to a pick event and added to the queue.
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
	   }

	   public void doMe() {
	      
	      state.update(this);
	       
	      this.state.getSuperMarket().addCustomer(customer);
	      
	      if(customer.getState() == CustomerState.inSuperMarket) {
	    	  double pickTime = this.time + state.getPickTime().next();
	    	  pickEvent = new Pick(this.state, this.eventList, customer, pickTime);
	    	  eventList.addEvent(pickEvent);
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
	   }
}
