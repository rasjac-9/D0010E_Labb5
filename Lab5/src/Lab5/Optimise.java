
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
	static String[] str1 = { "1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "false" };
	static String[] str2 = { "13", "2", "7", "3.0", "8.0", "0.6", "0.9", "0.35", "0.6", "false" };

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
//		Andrelina(1234);
		/*int[] str1 = { 1234, 2, 7 };
		opti(str1[0]);
		
		int counter = 0;
		Random rand = new Random(1234);
		while(counter < 100) {
			opti(rand.nextInt());
			counter++;
		}*/
		Andrelina(SEED);
		//opti(13);
	}

	
	public int slutTillstånd(int[] args) {
		Simulation nice = new Simulation();
		State s = nice.run(args[0], args[1], M, L, END_TIME, LOW_COLLECTION_TIME,
				HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME, HIGH_PAYMENT_TIME, false);

		int lol = ((SuperMarket) s).getLostCustomer();

		//System.out.println(lol);
		return lol;
	}

	public int opti(int kuk) {
		
		int[] configs = {kuk, 1, 5};
		int antReg = 0;
		int oldLost = Integer.MAX_VALUE;
		int lost;

		for (int regs = M; regs >= 1; regs--) {
			configs[1] = regs;
			lost = slutTillstånd(configs);

			if (lost > oldLost) {
				break;
			}
			oldLost = lost;
			antReg = regs;
		}
		//System.out.println(antReg);
		//System.out.println(antReg+" "+oldLost);
		return antReg;
	}

	// Andres är obetald praktikan på bolaget och det är hans uppgift att optimera
	// butikerna
	public void Andrelina(int seed) {
		Random rand = new Random(seed);
		int oldReg = 0;
		int counter = 0;
		
		while(counter < 100) {
			int reg = opti(rand.nextInt());

			//System.out.println(reg);
			//System.out.println(counter);
			if(reg == oldReg) {
				counter++;
			} else if (oldReg < reg) {
				//System.out.println(counter);
				oldReg = reg;
				counter = 0;
			} else {
				//System.out.println(counter);
				oldReg = reg;
				counter = 0;
			}
		}
		System.out.println("DUN");
	}
}
