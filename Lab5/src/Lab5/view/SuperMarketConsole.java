
package Lab5.view;

import Lab5.RunConfig;
import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Observable;

/**
 * Prints the events to the console
 *
 * @author Alex Bergdahl,
 * @author Kim Eriksson,
 * @author Peggy Khialie,
 * @author Rasmus Jacobsen
 *
 */
public class SuperMarketConsole extends View {

	/**
	 * prints the configurations
	 * 
	 * @param rc - RunConfig file whit all the config files
	 */
	public SuperMarketConsole(RunConfig rc) {
		System.out.println("Parametrar\n==========\nAntal kassor, N..........: " + rc.regLimit
				+ "\nMax som ryms, M..........: " + rc.CLimit + "\nAnkomshastighet,  lamda..: " + rc.lambda
				+ "\nPlocktider, [P_min..Pmax]: [" + rc.pMin + ".." + rc.pMax + "]\nBetaltider, [K_min..Kmax]: ["
				+ rc.kMin + ".." + rc.kMax + "]\nFrö, f...................: " + rc.seed);

		System.out.println("\nFörlopp\n=======\nTid\t" + "Händelse\t" + "Kund\t" + "?\t" + "led\t" + "ledT\t" + "I\t"
				+ "$\t" + ":-(\t" + "köat\t" + "köT\t" + "köar\t" + "[Kassakö..]");
	}

	/**
	 * Prints the event every time a event happens
	 */
	@Override
	public void update(Observable o, Object arg) {
		DecimalFormat df2 = new DecimalFormat("#.##");
		df2.setRoundingMode(RoundingMode.UP);

		Event event = (Event) arg;
		SuperMarket superMarket = (SuperMarket) event.s;

		BigDecimal currentTime = new BigDecimal(event.time).setScale(2, RoundingMode.HALF_UP);
		BigDecimal regTime = new BigDecimal(superMarket.regTime).setScale(2, RoundingMode.HALF_UP);
		BigDecimal queueTime = new BigDecimal(superMarket.queueTime).setScale(2, RoundingMode.HALF_UP);

		// Special print for Start event
		if (event.getName() == "Start") {
			System.out.println(currentTime + "\t" + event.getName());
		}
		// Special print for Stop event
		else if (event.getName() == "Stop") {

			// Average time cash register was empty in time
			BigDecimal avgRegTime = new BigDecimal(superMarket.regTime / superMarket.cashRegLimit).setScale(2,
					RoundingMode.HALF_UP);

			// Average time cash register was empty in %
			BigDecimal avgInPerc = new BigDecimal(
					((superMarket.regTime / superMarket.cashRegLimit) / superMarket.lastEventTime) * 100).setScale(2,
							RoundingMode.HALF_UP);

			// Average time some one queue
			BigDecimal avgQueueTime = new BigDecimal(superMarket.queueTime / superMarket.cashQueue.queueCounter)
					.setScale(2, RoundingMode.HALF_UP);

			System.out.println(currentTime + "\t" + event.getName());

			System.out.println("\n" + "RESULTAT\n========");

			// Total amount of customers that the store have dealt whit
			int allCustomers = superMarket.getTotalCustomers() + superMarket.getLostCustomer();

			// Point 1 prints customer line
			System.out.println("\n1)\tAv " + allCustomers + " kunder handlade " + superMarket.getTotalCustomers()
					+ " medan " + superMarket.getLostCustomer() + " missades.");

			// Point 2 prints related to cash register time
			System.out.println("\n2)\tTotal tid " + superMarket.getMaxRegs() + " kassor varit " + "lediga: " + regTime
					+ " te." + "\n\tGenomsnittlig ledig kassatid: " + avgRegTime + " te (dvs " + avgInPerc
					+ "% av tiden från öppning tills sita kunden betalat)");

			// Point 3 prints related to how many people that have queued
			System.out.println("\n3)\tTotal tid " + superMarket.cashQueue.queueCounter + " kunder tvingats köa: "
					+ queueTime + " te.\n\tGenomsnittlig kötid: " + avgQueueTime + " te.");

			// Special variation when the store closes
		} else if (event.getName() == "Stänger") {
			System.out.println(currentTime + "\t" + event.getName() + "       ---\t" + "Ö\t"
					+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers() + "\t"
					+ superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
					+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
					+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
		}
		// Every print when a event happens
		else {
			// different print "Ö" or "S" depending on open or not
			if (superMarket.getOpenForBis()) {
				// Special case fore payment ass it have different length
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID() + "\tÖ\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				}
				// Every day events
				else {
					System.out.println(currentTime + "\t" + event.getName() + "\t\t" + event.getCustomerID() + "\tÖ\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				}
			} else {
				// Special case fore payment ass it have different length
				if (event.getName() == "Betalning") {
					System.out.println(currentTime + "\t" + event.getName() + "\t" + event.getCustomerID() + "\tS\t"
							+ superMarket.getAvailableCashReg() + "\t" + regTime + "\t" + superMarket.getCustomers()
							+ "\t" + superMarket.getShopped() + "\t" + superMarket.getLostCustomer() + "\t"
							+ superMarket.cashQueue.queueCounter + "\t" + queueTime + "\t" + "\t"
							+ superMarket.cashQueue.getSize() + "\t" + superMarket.cashQueue.getQue());
				}
				// Every day events
				else {
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
