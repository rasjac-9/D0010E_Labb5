
package Lab5.state;

import Lab5.simulation.State;

public class SuperMarket extends State {

	boolean openForBis;
	int availableCashReg, lostCustomer, inStore;

	final int cashRegLimit;
	final int customerLimit;

	public SuperMarket(int regLimit, int CLimit) {
		cashRegLimit = regLimit;
		customerLimit = CLimit;

		availableCashReg = regLimit;
		lostCustomer = 0;
		inStore = 0;

		TimeState time = new TimeState();
		// TODO: parhaps create a view ??
	}

	public void addCustomer() throws ArithmeticException {
		if (inStore == customerLimit) {
			throw new ArithmeticException();
		} else {
			inStore += 1;
		}
	}

	public void customerLeft() {
		if (inStore != 0) {
			inStore -= 1;
		}
	}

	public void lostCustomer() {
		lostCustomer += 1;
	}

	public void addToCashReg() {
		if (availableCashReg != 0) {
			availableCashReg -= 1;
		}
	}

	public void freeCashReg() throws ArithmeticException {
		if (availableCashReg == cashRegLimit) {
			throw new ArithmeticException();
		} else {
			availableCashReg += 1;
		}
	}

	public int getAvailableCashReg() {
		return cashRegLimit - availableCashReg;
	}

}
