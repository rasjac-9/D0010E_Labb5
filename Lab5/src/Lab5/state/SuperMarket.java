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

import Lab5.simulation.State;

public class SuperMarket extends State {

	boolean openForBis;
	int occupiedCashReg, lostCustomer, inStore, lambda, seed;
	double kmax, kmin, pmin, pmax;

	final int cashRegLimit;
	final int customerLimit;

	/**
	 * Starts the SuperMarket
	 * 
	 * @param regLimit - the limit on how many cashRegisters that exists
	 * @param CLimit   - the limit on how many customers aloud in store
	 */
	public SuperMarket(int seed, int regLimit, int CLimit, int lambda, int pmin, int pmax, int kmin, int kmax) {
		this.kmax = kmax;
		this.kmin = kmin;
		this.pmin = pmin;
		this.pmax = pmax;
		this.lambda = lambda;
		this.seed = seed;
		cashRegLimit = regLimit;
		customerLimit = CLimit;

		openForBis = true;
		occupiedCashReg = regLimit;
		lostCustomer = 0;
		inStore = 0;

		TimeState time = new TimeState(this);
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

	public void closeStore() {
		openForBis = false;
	}

	public boolean getOpenForBis() {
		return openForBis;
	}
}
