package Lab5.view;

import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.util.Observable;

public class SuperMarketConsole extends View {

    public SuperMarketConsole() {
        System.out.println("Tid " + "Händelse " + "Kund " + "? " + "led "
                            + "ledT " + "I " + "$ " + ":-( " + "köat "
                            + "köT " + "köar " + "[Kassakö..]");
    }

    @Override
    public void update(Observable o, Object arg) {

        Event event = (Event) arg;
        SuperMarket superMarket = (SuperMarket) event.s;

        if(event.getName() == "Start") {
            System.out.println(event.time+" "+event.getName());
        } else {

            // TODO: add time that there have been empty cashReg (EMPTYCASHREGTIME)
            // TODO: counter for how many customers had to FIFOque (FIFOQUECOUNTER)
            // different print "Ö" or "S" depending on open or not
            if(superMarket.getOpenForBis()) {
                System.out.println(event.time + " " + event.getName() + "   " + superMarket.getCustomers()
                        + "   Ö  " + superMarket.getAvailableCashReg() + "  " + superMarket.regTime + "  "
                        + superMarket.getCustomers() + " " + superMarket.getShopped() + "  "
                        + superMarket.getLostCustomer() + "   " + superMarket.cashQueue.queueCounter + "   " + superMarket.queueTime +
                        " " + " " + superMarket.cashQueue.getSize() + "       " + superMarket.cashQueue.getQue());
            } else {
                System.out.println(event.time + " " + event.getName() + "   " + superMarket.getCustomers()
                        + "   S  " + superMarket.getAvailableCashReg() + "  " + superMarket.regTime + "  "
                        + superMarket.getCustomers() + " " + superMarket.getShopped() + "  "
                        + superMarket.getLostCustomer() + "   " + superMarket.cashQueue.queueCounter + "   " + superMarket.queueTime +
                        " " + " " + superMarket.cashQueue.getSize() + "       " + superMarket.cashQueue.getQue());
            }
        }
    }
}
