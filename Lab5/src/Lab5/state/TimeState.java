
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
		ranStreamShop = new UniformRandomStream(s.kmin, s.kmax, s.seed);
		ranStreamPick = new UniformRandomStream(s.pmin, s.pmax, s.seed);
		expStream = new ExponentialRandomStream(s.lambda, s.seed);

		regTime = 0.0;
		queueTime = 0.0;
		currentTime = 0.0;

		callClosingEvent();
	}

	private void callClosingEvent() {
		ClosingEvent ce = new ClosingEvent(sm, closingTime);
	}

	public double getArrivalTime() {
		return currentTime + expStream.next();
	}

	public double getPayTime() {
		return currentTime + ranStreamShop.next();
	}

	public double getPickTime() {
		return currentTime + ranStreamPick.next();
	}

	public void togelRegTime() {
		if (sm.occupiedCashReg > 0) {
			sm.emptyReg = false;
		} else {
			sm.emptyReg = true;
		}
	}

	public void togelQueueTime() {
		if (!sm.cashQueue.isEmpty()) {
			sm.inQueue = true;
		} else {
			sm.inQueue = false;
		}
	}

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
