
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.simulation.State;
import Lab5.state.SuperMarket;

/**
 * Stops the simulation
 *
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
public class StopEvent extends Event {

    StopEvent(State state, EventQueue eq) {
        s = state;
        EventQueue = eq;
        
        if(!((SuperMarket)s).getOpenForBis() && EventQueue.isEmpty()) {
        	s.stop = true;
        }    	
    }
}
