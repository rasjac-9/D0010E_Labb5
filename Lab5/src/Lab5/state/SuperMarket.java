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
	int availableCashReg, lostCustomer, inStore;

	final int cashRegLimit;
	final int customerLimit;
	
	public TimeState ts;

	/**
	 * Starts the SuperMarket
	 * 
	 * @param regLimit - the limit on how many cashRegisters that exists
	 * @param CLimit   - the limit on how many customers aloud in store
	 */
	public SuperMarket(int seed, int regLimit, int CLimit) {
		cashRegLimit = regLimit;
		customerLimit = CLimit;

		openForBis = true;
		availableCashReg = regLimit;
		lostCustomer = 0;
		inStore = 0;

		ts = new TimeState(seed);
		// TODO: parhaps create a view ??
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
	 * Decrease availableCashReg
	 */
	public void addToCashReg() {
		if (availableCashReg != 0) {
			availableCashReg -= 1;
		}
	}

	/**
	 * Adds to availableCashReg
	 * 
	 * @throws ArithmeticException - if cashRegLimit is reached
	 */
	public void freeCashReg() throws ArithmeticException {
		if (availableCashReg == cashRegLimit) {
			throw new ArithmeticException();
		} else {
			availableCashReg += 1;
		}
	}

	/**
	 * @return the amount of availableCashReg
	 */
	public int getAvailableCashReg() {
		return cashRegLimit - availableCashReg;
	}
	
	public void closeStore() {
		openForBis = false;
	}
	
	public boolean getOpenForBis() {
		return openForBis;
	}
}
