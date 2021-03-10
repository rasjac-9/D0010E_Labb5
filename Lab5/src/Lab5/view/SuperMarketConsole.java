package Lab5.view;

import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.util.Observable;

public class SuperMarketConsole extends View {

	public SuperMarketConsole() {
		System.out.println("Tid\t" + "Händelse\t" + "Kund\t" + "?\t" + "led\t" + "ledT\t" + "I\t" + "$\t" + ":-(\t"
				+ "köat\t" + "köT\t" + "köar\t" + "[Kassakö..]");
	}

	@Override
	public void update(Observable o, Object arg) {

		Event event = (Event) arg;
		SuperMarket superMarket = (SuperMarket) event.s;

		double currentTime = Math.round(event.time * 100.0) / 100.0;
		double regTime = Math.round(superMarket.regTime * 100.0) / 100.0;
		double queueTime = Math.round(superMarket.queueTime * 100.0) / 100.0;

		if (event.getName() == "Start") {
			System.out.println(event.time + "\t" + event.getName());
		}
		else if (event.getName() == "Stop") {
			System.out.println(event.time + "\t" + event.getName());
		} else {

			// TODO: add time that there have been empty cashReg (EMPTYCASHREGTIME)
			// TODO: counter for how many customers had to FIFOque (FIFOQUECOUNTER)
			// different print "Ö" or "S" depending on open or not
			if (superMarket.getOpenForBis()) {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + superMarket.getCustomers()
							+ "\tÖ\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + superMarket.getCustomers()
							+ "\tÖ\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				}
			} else {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + superMarket.getCustomers()
							+ "\tS\t" + superMarket.getAvailableCashReg() + "\t" + regTime + "\t"
							+ superMarket.getCustomers() + "\t" + superMarket.getShopped() + "\t"
							+ superMarket.getLostCustomer() + "\t" + superMarket.cashQueue.queueCounter + "\t"
							+ queueTime + "\t" + "\t" + superMarket.cashQueue.getSize() + "\t"
							+ superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + superMarket.getCustomers()
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
