package Lab5.state;

public class SuperMarket {
	
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
		inStore += 1;
	}
	
	public void customerLeft() {
		inStore -= 1;
	}
	
	public void lostCustomer() {
		lostCustomer += 1;
	}
	
	public int addToCashReg() throws ArithmeticException{
		if (cashReg == 0) {
			throw new ArithmeticException();
		}else {
			cashReg -= 1;
		}
		
		return cashReg;
	}
	
	public void availableCashReg(){
		if (cashReg != cashRegLimit) {
			cashReg -= 1;
		}
	}
	
}
