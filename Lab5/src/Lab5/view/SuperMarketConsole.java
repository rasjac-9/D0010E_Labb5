package Lab5.view;

import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Observable;

public class SuperMarketConsole extends View {

	public SuperMarketConsole() {
		System.out.println("Tid\t" + "Händelse\t" + "Kund\t" + "?\t" + "led\t" + "ledT\t" + "I\t" + "$\t" + ":-(\t"
				+ "köat\t" + "köT\t" + "köar\t" + "[Kassakö..]");
	}

	@Override
	public void update(Observable o, Object arg) {
		DecimalFormat df2 = new DecimalFormat("#.##");
		df2.setRoundingMode(RoundingMode.UP);

		Event event = (Event) arg;
		SuperMarket superMarket = (SuperMarket) event.s;

		BigDecimal currentTime = new BigDecimal(event.time).setScale(2, RoundingMode.HALF_UP);
		BigDecimal regTime = new BigDecimal(superMarket.regTime).setScale(2, RoundingMode.HALF_UP);
		BigDecimal queueTime = new BigDecimal(superMarket.queueTime).setScale(2, RoundingMode.HALF_UP);

		if (event.getName() == "Start") {
			System.out.println(event.time + "\t" + event.getName());
		}
		else if (event.getName() == "Stop") {
			System.out.println(event.time + "\t" + event.getName());
		}
		else if (event.getName() == "Stänger") {
			System.out.println(currentTime + "\t" + event.getName() + "       ---\t"
					+ "Ö\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
					+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
					+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
					+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
					+ superMarket.cashQueue.getQue());
		}
		else {

			// TODO: add time that there have been empty cashReg (EMPTYCASHREGTIME) 
			// TODO: counter for how many customers had to FIFOque (FIFOQUECOUNTER)
			// different print "Ö" or "S" depending on open or not
			if (superMarket.getOpenForBis()) {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID()
							+ "\tÖ\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + event.getCustomerID()
							+ "\tÖ\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				}
			} else {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID()
							+ "\tS\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + event.getCustomerID()
							+ "\tS\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				}
			}
		}
	}
}
