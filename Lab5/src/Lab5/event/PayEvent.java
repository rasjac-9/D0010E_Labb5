package Lab5.event;

import Lab5.simulation.Event;
import Lab5.state.SuperMarket;

public class PayEvent extends Event {
    PayEvent(SuperMarket superMarket, int ID) {
        customerID = ID;
        superMarket.customerLeft();

        //TODO: FIFOvar needs change
        if(!superMarket.FIFOvar.isEmpty) {
        }
    }
}
