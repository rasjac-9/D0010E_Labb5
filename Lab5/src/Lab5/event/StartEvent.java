
package Lab5.event;

import Lab5.simulation.View;
import Lab5.state.SuperMarket;

/**
 * Starts the SuperMarket
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
public class StartEvent {
    SuperMarket superMarket;
    View view;

    StartEvent(int seed, int cashLim, int CLim) {
        superMarket = new SuperMarket(seed, cashLim, CLim);

        // EventQue variable not added to superMarket yet
        superMarket.EventQueue.addEvent(new ArrivalEvent(0));
       
        // view in StartEvent (?)
        view = new View();
    }
}
