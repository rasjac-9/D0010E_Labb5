package Lab5.view;

import Lab5.simulation.Event;
import Lab5.simulation.View;
import Lab5.state.SuperMarket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Observable;

public class SuperMarketFile extends View {
    @Override
    public void update(Observable o, Object arg) {
        Event event = (Event) arg;
        SuperMarket superMarket = (SuperMarket) event.s;

        BigDecimal currentTime = new BigDecimal(event.time).setScale(2, RoundingMode.HALF_UP);
        BigDecimal regTime = new BigDecimal(superMarket.regTime).setScale(2, RoundingMode.HALF_UP);
        BigDecimal queueTime = new BigDecimal(superMarket.queueTime).setScale(2, RoundingMode.HALF_UP);

        if(!(event.getName() == "Stop")) {
            try {
                File file = new File("optimization.txt");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                PrintWriter writer = new PrintWriter("optimization.txt");
                writer.write(superMarket.getLostCustomer()+"\n"+currentTime+"\n"+regTime+"\n"+
                        superMarket.cashQueue.queueCounter+"\n"+queueTime);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
