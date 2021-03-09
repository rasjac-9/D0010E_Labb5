
package Lab5.event;

import Lab5.simulation.View;
import Lab5.simulation.Event;
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
public class StartEvent extends Event{
	SuperMarket superMarket;
	View view;

	StartEvent(EventQueue eq, int seed, int regLimit, int CLimit, int lambda, int pmin, int pmax, int kmin, int kmax) {
		superMarket = new SuperMarket(seed, regLimit, CLimit, lambda, pmin, pmax, kmin, kmax);
		EventQueue = eq;
		
		// EventQue variable not added to superMarket yet
		EventQueue.addEvent(new ArrivalEvent(0, superMarket));

		// view in StartEvent (?)
		view = new View();
	}
}
