
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

public class Optimise {
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
		int[] str1 = { 1234, 2, 7 };
		opti(str1[0]);
		
		int counter = 0;
		Random rand = new Random(1234);
		while(counter < 100) {
			opti(rand.nextInt());
			counter++;
		}
	}

	
	public int slutTillstånd(int[] args) {
		Simulation nice = new Simulation();
		State s = new State();
		s = nice.run(args);

		int lol = ((SuperMarket) s).getLostCustomer();

		return lol;
	}

	public int opti(int kuk) {
		
		int[] configs = {kuk, 1, 5};
		int antReg;
		int oldLost = kuk;
		int lost;

		for (antReg = 1; antReg <= configs[2]; antReg++) {
			configs[1] = antReg;
			lost = slutTillstånd(configs);

			if (oldLost > lost) {
				oldLost = lost;
			} else if (oldLost == lost) {
				break;
			}
		}
		System.out.println(antReg);
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

			System.out.println(reg);
			if(reg == oldReg) {
				counter++;
			} else if (oldReg < reg) {
				oldReg = reg;
				counter = 0;
			} else {
				counter = 0;
			}
		}
		System.out.println("DUN");
	}
}
