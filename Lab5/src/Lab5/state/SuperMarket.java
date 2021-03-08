
package Lab5.state;

public class SuperMarket extends State{

	boolean openForBis;
	int cashReg, lostCustomer, inStore;

	final int cashRegLimit;
	final int customerLimit;

	public SuperMarket(int regLimit, int CLimit) {
		cashRegLimit = regLimit;
		customerLimit = CLimit;

		cashReg = regLimit;
		lostCustomer = 0;
		inStore = 0;

		TimeState time = new TimeState();
		// TODO: parhaps create a view ??
	}

	public void addCustomer() {
		if (inStore != customerLimit) {
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
		if (cashReg != 0) {
			cashReg -= 1;
		}
	}

	public void freeCashReg() {
		if (cashReg != cashRegLimit) {
			cashReg -= 1;
		}
	}

	public int getAvailableCashReg() {
		return cashRegLimit - cashReg;
	}

}
