
package Lab5.state;

import Lab5.rand.*;
import Lab5.event.*;

/**
 * Gives time to event and keep track of time
 * 
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class TimeState {

	private UniformRandomStream ranStreamShop;
	private ExponentialRandomStream expStream;
	private UniformRandomStream ranStreamPick;

	protected double shopTime;
	private double closingTime;

	SuperMarket sm;

	public TimeState(SuperMarket s) {
		sm = s;
		ranStreamShop 	= new UniformRandomStream(s.kmin, s.kmax, s.seed);
		ranStreamPick 	= new UniformRandomStream(s.pmin, s.pmax, s.seed);
		expStream 		= new ExponentialRandomStream(s.lambda, s.seed);


		closingTime = sm.closingTime;
	}

	/**
	 * Creates a closing event
	 */
	public void callClosingEvent() {
		System.out.println(closingTime);
		sm.eventQueue.addEvent(new ClosingEvent(sm, closingTime));
		//ClosingEvent ce = new ClosingEvent(sm, closingTime);
	}

	/**
	 * @return double arrival time
	 */
	public double getArrivalTime() {
		return sm.currentTime + expStream.next();
	}

	/**
	 * @return double pay time
	 */
	public double getPayTime() {
		return sm.currentTime + ranStreamShop.next();
	}

	/**
	 * @return double pick time
	 */
	public double getPickTime() {
		return sm.currentTime + ranStreamPick.next();
	}

}
