/**
 * Description
 * 
 * @author Alex Bergdahl, 
 * @author Kim Eriksson, 
 * @author Peggy Khialie, 
 * @author Rasmus Jacobsen
 *
 */
package Lab5.state;
import Lab5.rand.*;

public class TimeState {
	private UniformRandomStream ranStreamShop;
	private ExponentialRandomStream expStream;
	private UniformRandomStream ranStreamPick;
	protected int shopTime;
	public int regTime;
	public int queueTime;
	private int closingTime;
	private int currentTime;
	
	public TimeState(SuperMarket s) {
		ranStreamShop = new UniformRandomStream(s.kmin,s.kmax,s.seed);
		ranStreamPick = new UniformRandomStream(s.pmin,s.pmax,s.seed);
		expStream = new ExponentialRandomStream(s.lambda,s.seed);
	}
	private int callClosingEvent() {
		return closingTime;
	}
	public double getArrivalTime() {
		return expStream.next();
	}
	public double getPayTime() {
		return ranStreamShop.next();
	}
	public double getPickTime() {
		return ranStreamPick.next();
}
	public void togetRegTime() {
		
	}
}
