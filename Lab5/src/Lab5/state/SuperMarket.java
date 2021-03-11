
package Lab5.state;

import Lab5.RunConfig;
import Lab5.event.EventQueue;
import Lab5.simulation.Event;
import Lab5.simulation.State;
import Lab5.simulation.View;

/**
 * Description
 *
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class SuperMarket extends State {

	boolean openForBis, emptyReg, inQueue;

	int occupiedCashReg, lostCustomer, inStore, seed, shopped, availableCashReg, totalCustomers;
	double lambda, closingTime, kmax, kmin, pmin, pmax;

	public final int cashRegLimit;
	final int customerLimit;
	public double lastEventTime;
	public double regTime;
	public double queueTime;
	public TimeState ts;
	public FIFO cashQueue;
	public View view;

	/**
	 * Starts the SuperMarket
	 * 
	 * @param rc - Configuration with parameters
	 */
	public SuperMarket(RunConfig rc, EventQueue eq) {
		this.kmax = rc.kMax;
		this.kmin = rc.kMin;
		this.pmin = rc.pMin;
		this.pmax = rc.pMax;
		this.seed = rc.seed;
		this.lambda = rc.lambda;
		this.closingTime = rc.closingTime;
		this.regTime = 0.0;
		this.queueTime = 0.0;

		cashQueue = new FIFO();
		cashRegLimit = rc.regLimit;
		availableCashReg = rc.regLimit;
		customerLimit = rc.CLimit;

		this.view = rc.view;
		this.addObserver(view);
		this.closingTime = rc.closingTime;
		
		eventQueue = eq;
		openForBis = true;
		emptyReg = true;
		inQueue = false;
		
		totalCustomers = 0;
		lostCustomer = 0;
		inStore = 0;

		ts = new TimeState(this);
	}

	/**
	 * Adds a customer to the store
	 *
	 * @throws ArithmeticException - if customerLimtit is reached
	 */
	public boolean addCustomer() {
		if (inStore == customerLimit) {
			return false;
		} else {
			totalCustomers += 1;
			inStore += 1;
			return true;
		}
	}

	/**
	 * Removes customer from store
	 */
	public void customerLeft() {
		if (inStore != 0) {
			inStore -= 1;
			shopped += 1;
			freeCashReg();
		}
	}

	/**
	 * Adds to amount of customers that wasn't aloud in the store
	 */
	public void lostCustomer() {
		lostCustomer += 1;
	}

	/**
	 * Adds to occupiedCashReg
	 */
	public void addToCashReg() throws ArithmeticException {
		if (availableCashReg == 0) {
			throw new ArithmeticException();
		} else {
			availableCashReg -= 1;
		}
	}

	/**
	 * Decrease occupiedCashReg
	 *
	 * @throws ArithmeticException - if cashRegLimit is reached
	 */
	public void freeCashReg() {
		if (availableCashReg != cashRegLimit) {
			availableCashReg += 1;
		}
	}

	/**
	 * @return the amount of occupiedCashReg
	 */
	public int getAvailableCashReg() {
		return availableCashReg;
	}

	/**
	 * Closes the store
	 */
	public void closeStore() {
		openForBis = false;
	}

	/**
	 * @return - true/false if the store is open/closed
	 */
	public boolean getOpenForBis() {
		return openForBis;
	}

	/**
	 * Returns the amount of people in the store currently.
	 * 
	 * @return
	 */
	public int getCustomers() {
		return inStore;
	}

	/**
	 * Returns the amount of people that have successfully paid.
	 * 
	 * @return
	 */
	public int getShopped() {
		return shopped;
	}

	/**
	 * returns the amount of missed customers if the store is full.
	 * 
	 * @return
	 */
	public int getLostCustomer() {
		return lostCustomer;
	}

	/**
	 * Returns the total amount of people that tried to shop.
	 * 
	 * @return
	 */
	public int getTotalCustomers() {
		return totalCustomers;
	}

	/**
	 * Returns the amount of cash registers in the store.
	 * 
	 * @return
	 */
	public int getMaxRegs() {
		return cashRegLimit;
	}

	/**
	 * Update method that updates the time available cash registers has been empty.
	 * It updates the total queue time of all customers. Updates the current time
	 * and then notifies the observes. This method is called before every event
	 * happens.
	 * 
	 * @param event
	 */
	public void viewUpdate(Event event) {
		if (availableCashReg != 0) {
			if (!openForBis && event.getName() == "Ankomst") {

			} else {
				regTime += (event.time - currentTime) * availableCashReg;
			}

		}
		if (!cashQueue.isEmpty()) {
			queueTime += (event.time - currentTime) * cashQueue.getSize();
		}
		currentTime = event.time;
		if (!openForBis && event.getName() == "Ankomst") {

		} else {
			lastEventTime = event.time;
		}
		setChanged();
		notifyObservers(event);
	}

	/**
	 * specific viewUpdate for stopEvent
	 * 
	 * @param event - the stop event
	 */
	public void stopUpdate(Event event) {
		setChanged();
		notifyObservers(event);
	}
}
