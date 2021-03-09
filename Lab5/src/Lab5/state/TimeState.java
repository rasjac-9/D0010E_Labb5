
/**
 * Gives time to event and keep track of time
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
package Lab5.state;

import Lab5.rand.*;
import Lab5.event.*;

public class TimeState {
	
	private UniformRandomStream ranStreamShop;
	private ExponentialRandomStream expStream;
	private UniformRandomStream ranStreamPick;
	
	protected int shopTime;
	
	public int regTime;
	public int queueTime;
	
	private int closingTime;
	private int currentTime;
	
	SuperMarket sm;

	public TimeState(SuperMarket s) {
		sm = s;
		ranStreamShop = new UniformRandomStream(s.kmin, s.kmax, s.seed);
		ranStreamPick = new UniformRandomStream(s.pmin, s.pmax, s.seed);
		expStream = new ExponentialRandomStream(s.lambda, s.seed);
		
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

	public void togetRegTime() {

	}
}
