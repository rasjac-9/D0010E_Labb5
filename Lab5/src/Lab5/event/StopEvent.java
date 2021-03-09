
package Lab5.event;

import Lab5.simulation.Event;
import Lab5.simulation.State;

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

    StopEvent(State state) {
        state.stop = true;
    }
}
