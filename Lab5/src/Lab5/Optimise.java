
package Lab5;

import Lab5.simulation.State;
import Lab5.state.SuperMarket;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
import java.util.Random;
//import java.util.Scanner;
//
//import static java.lang.Double.parseDouble;
//import static java.lang.Integer.parseInt;

public class Optimise implements K {
//	static String[] str1 = { "1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "false" };
//	static String[] str2 = { "13", "2", "7", "3.0", "8.0", "0.6", "0.9", "0.35", "0.6", "false" };
	public static void main(String[] args) {
	//System.out.println(Två(1234));

	}
	/**
	 * The method runs a simulation and stores the output values of the simulation
	 * in an array
	 *
	 * @author Alex Bergdahl,
	 * @author Kim Eriksson,
	 * @author Peggy Khialie,
	 * @author Rasmus Jacobsen
	 *
	 */
	Optimise() {
     Tre(SEED);
     
			

	}

	
	public  State Ett(int a,int b) {

		Simulation nice = new Simulation();
		State s = nice.run(a, b, M, L, END_TIME, LOW_COLLECTION_TIME,
				HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, false);
		return s;

	}

	 public  int Två(int seed) {
	 State state;
	 int missC = 100000;
	 int bestreg = 0;
	 
	 for (int reg = M; reg >= 1; reg--) {
		 state = Ett(seed,reg);
		 if (state.getLostCustomer() > missC) {
			 bestreg = reg;
			 break;
		 }
		 missC = state.getLostCustomer();
		 bestreg = reg;
	 }
	 return bestreg;
	 }

	// Andres är obetald praktikan på bolaget och det är hans uppgift att optimera
	// butikerna
	public void Tre(int seed) {
	Random random = new Random(seed);
	int counter = 0;
	int bra = 0;
	int varv = 1;
	
	while (true) {
		int temp = Två(random.nextInt());
		System.out.println(temp+"       "+ "Counter: "+ counter);
		if (temp > bra) {
			counter = 0;
			bra = temp;
		} else {
			counter ++;
		} 
		if (counter == 100) {
			break;
		}
		
		varv++;

	}
	System.out.println("ANTAL KASSOR: "+ bra + "," + "  " + "ANTAL VARV: " + varv);
}
}
