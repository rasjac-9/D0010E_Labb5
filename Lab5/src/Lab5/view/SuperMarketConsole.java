package Lab5.view;

import Lab5.RunConfig;
import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Observable;

public class SuperMarketConsole extends View {

	public SuperMarketConsole(RunConfig rc) {
		System.out.println("Parametrar\n==========\nAntal kassor, N..........: " + rc.regLimit
				+ "\nMax som ryms, M..........: " + rc.CLimit + "\nAnkomshastighet,  lamda..: " + rc.lambda
				+ "\nPlocktider, [P_min..Pmax]: [" + rc.pMin + ".." + rc.pMax + "]\nBetaltider, [K_min..Kmax]: ["
				+ rc.kMin + ".." + rc.kMax + "]\nFrö, f...................: " + rc.seed);

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
			System.out.println(currentTime + "\t" + event.getName());
		} else if (event.getName() == "Stop") {

			BigDecimal avgRegTime = new BigDecimal(superMarket.regTime / superMarket.cashRegLimit).setScale(2,
					RoundingMode.HALF_UP);

			BigDecimal avgInPerc = new BigDecimal(
					((superMarket.regTime / superMarket.cashRegLimit) / superMarket.lastEventTime) * 100).setScale(2,
							RoundingMode.HALF_UP);

			BigDecimal avgQueueTime = new BigDecimal(superMarket.queueTime / superMarket.cashQueue.queueCounter)
					.setScale(2, RoundingMode.HALF_UP);

			System.out.println(currentTime + "\t" + event.getName());

			System.out.println("\n" + "RESULTAT\n========");

			int allCustomers = superMarket.getTotalCustomers() + superMarket.getLostCustomer();
			System.out.println("\n1)\tAv " + allCustomers + " kunder handlade " + superMarket.getTotalCustomers()
					+ " medan " + superMarket.getLostCustomer() + " missades.");

			System.out.println("\n2)\tTotal tid " + superMarket.getMaxRegs() + " kassor varit " + "lediga: " + regTime
					+ " te." + "\n\tGenomsnittlig ledig kassatid: " + avgRegTime + " te (dvs " + avgInPerc
					+ "% av tiden från öppning tills sita kunden betalat)");

			System.out.println("\n3)\tTotal tid " + superMarket.cashQueue.queueCounter + " kunder tvingats köa: "
					+ queueTime + " te.\n\tGenomsnittlig kötid: " + avgQueueTime + " te.");
		} else if (event.getName() == "Stänger") {
			System.out.println(currentTime + "\t" + event.getName() + "       ---\t" + "Ö\t"
					+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers() + "\t"
					+ superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
					+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
					+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
		} else {

			// TODO: add time that there have been empty cashReg (EMPTYCASHREGTIME)
			// TODO: counter for how many customers had to FIFOque (FIFOQUECOUNTER)
			// different print "Ö" or "S" depending on open or not
			if (superMarket.getOpenForBis()) {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID() + "\tÖ\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + event.getCustomerID() + "\tÖ\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				}
			} else {
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID() + "\tS\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				} else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + event.getCustomerID() + "\tS\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				}
			}
		}
	}
}
