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
	private ExponentialRandomStream expClose;
	private int arrivalTime;
	private int payTime;
	protected int shopTime;
	public int regTime;
	public int queueTime;
	
	public TimeState(SuperMarket s) {
		ranStreamShop = new UniformRandomStream(s.kmin,s.kmax,s.seed);
		ranStreamPick = new UniformRandomStream(s.pmin,s.pmax,s.seed);
		expStream = new ExponentialRandomStream(s.lambda,s.seed);
		expClose = new ExponentialRandomStream(s.lambda,s.seed);
	}
	private void callClosingEvent() {

	}
}
