package Lab5.event;

import Lab5.simulation.View;
import Lab5.state.*;

public class StartEvent {
    SuperMarket superMarket;
    View view;

    StartEvent() {
        superMarket = new SuperMarket();

        // EventQue variable not added to superMarket yet
        superMarket.EventQueue.addEvent(new ArrivalEvent(0));
       
        // view in StartEvent (?)
        view = new View();
    }
}
