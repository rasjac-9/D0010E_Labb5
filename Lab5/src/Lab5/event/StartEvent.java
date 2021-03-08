
package Lab5.event;

import Lab5.simulation.View;
import Lab5.state.SuperMarket;
import Lab5.Simulation;
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

	StartEvent(int seed, int regLimit, int CLimit, int lambda, int pmin, int pmax, int kmin, int kmax) {
		superMarket = new SuperMarket(seed, regLimit, CLimit, lambda, pmin, pmax, kmin, kmax);

		// EventQue variable not added to superMarket yet
		SuperMarket.EventQueue.addEvent(new ArrivalEvent(0));

		// view in StartEvent (?)
		view = new View();
	}
}
