
package Lab5.state;

import Lab5.RunConfig;
import Lab5.simulation.State;

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

	int occupiedCashReg, lostCustomer, inStore, seed, shopped;
	double lambda, closingTime, kmax, kmin, pmin, pmax;

	final int cashRegLimit;
	final int customerLimit;

	public TimeState ts;
	public FIFO cashQueue;

	/**
	 * Starts the SuperMarket
	 * 
	 * @param regLimit - the limit on how many cashRegisters that exists
	 * @param CLimit   - the limit on how many customers aloud in store
	 */
	public SuperMarket(RunConfig rc) {
		this.kmax = rc.kMax;
		this.kmin = rc.kMin;
		this.pmin = rc.pMin;
		this.pmax = rc.pMax;
		this.seed = rc.seed;
		this.lambda = rc.lambda;
		this.closingTime = rc.closingTime;

		cashRegLimit = rc.regLimit;
		customerLimit = rc.CLimit;

		openForBis = true;
		emptyReg = true;
		inQueue = false;

		occupiedCashReg = 0;
		lostCustomer = 0;
		inStore = 0;

		ts = new TimeState(this);
	}

	/**
	 * Adds a customer to the store
	 *
	 * @throws ArithmeticException - if customerLimtit is reached
	 */
	public void addCustomer() throws ArithmeticException {
		if (inStore == customerLimit) {
			throw new ArithmeticException();
		} else {
			inStore += 1;
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
		if (occupiedCashReg == cashRegLimit) {
			throw new ArithmeticException();
		} else {
			occupiedCashReg += 1;
		}
	}

	/**
	 * Decrease occupiedCashReg
	 *
	 * @throws ArithmeticException - if cashRegLimit is reached
	 */
	public void freeCashReg() {
		if (occupiedCashReg != 0) {
			occupiedCashReg -= 1;
		}
	}

	/**
	 * @return the amount of occupiedCashReg
	 */
	public int getAvailableCashReg() {
		return cashRegLimit - occupiedCashReg;
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
}
