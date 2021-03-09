
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

	public double regTime;
	public double queueTime;
	public double currentTime;

	private double closingTime;

	SuperMarket sm;

	public TimeState(SuperMarket s) {
		sm = s;
		ranStreamShop 	= new UniformRandomStream(s.kmin, s.kmax, s.seed);
		ranStreamPick 	= new UniformRandomStream(s.pmin, s.pmax, s.seed);
		expStream 		= new ExponentialRandomStream(s.lambda, s.seed);

		regTime 	= 0.0;
		queueTime 	= 0.0;
		currentTime = 0.0;
		closingTime = sm.closingTime;

		callClosingEvent();
	}

	/**
	 * Creates a closing event
	 */
	private void callClosingEvent() {
		ClosingEvent ce = new ClosingEvent(sm, closingTime);
	}

	/**
	 * @return double arrival time
	 */
	public double getArrivalTime() {
		return currentTime + expStream.next();
	}

	/**
	 * @return double pay time
	 */
	public double getPayTime() {
		return currentTime + ranStreamShop.next();
	}

	/**
	 * @return double pick time
	 */
	public double getPickTime() {
		return currentTime + ranStreamPick.next();
	}

	/**
	 * Turns on/off if a cash register is empty or not
	 */
	public void togelRegTime() {
		if (sm.occupiedCashReg > 0) {
			sm.emptyReg = false;
		} else {
			sm.emptyReg = true;
		}
	}

	/**
	 * Turns on/off if some one is in the queue or not
	 */
	public void togelQueueTime() {
		if (!sm.cashQueue.isEmpty()) {
			sm.inQueue = true;
		} else {
			sm.inQueue = false;
		}
	}

	/**
	 * Updates the time 
	 */
	public void updateTime() {
		currentTime += 0.01;

		if (sm.emptyReg) {
			regTime += 0.01;
		}

		if (sm.inQueue) {
			queueTime += 0.01;
		}
	}
}
