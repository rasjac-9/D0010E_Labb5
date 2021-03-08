package Lab5.event;

import State.State

/**
 * Tells when the supermarket closes and does not let customers in the store.
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */

public class ClosingEvent extends Event {
  
  private double time;
  
  public ClosingEvent(State state, EventQueue eventList, double time) {
    super(state, eventQueue);
    this.time = time;    
  }

  public void doMe() {
    state.update(this);
    state.getSuperMarket().closeStore();
   }

   public double getTime() {
     return time;
   }
  
   public String getName() {
     return "Close";
   }

   public Customer getCustomer() {
     return null;
   }
}
