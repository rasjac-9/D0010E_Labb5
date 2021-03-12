
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
		// System.out.println(Två(1234));

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
		// Två(SEED);
		// Ett(SEED,14);

	}

	public State Ett(int a, int b) {

		Simulation nice = new Simulation();
		State s = nice.run(a, b, M, L, END_TIME, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME,
				HIGH_PAYMENT_TIME, false);
		return s;

	}

	public int Två(int seed) {
		State state;
		State state2;
		int cust = 0;
		int bestreg = 0;

		for (int reg = 1; reg < M; reg++) {
			state = Ett(seed, reg);
			cust = state.getLostCustomer();
			testTvå(cust);
			
			state2 = Ett(seed, reg+1);
			if (state.getLostCustomer() > state2.getLostCustomer()) {
				bestreg = reg;
			} else if (state.getLostCustomer() == state2.getLostCustomer()) {
				bestreg = reg;
				break;
			}
		}
		return bestreg;
	}

	// Andres är obetald praktikan på bolaget och det är hans uppgift att optimera
	// butikerna
	public int Tre(int seed) {
		Random random = new Random(seed);
		int counter = 0;
		int worstReg = 0;

		while (true) {
			int twoReg = Två(random.nextInt());
			if (twoReg > worstReg) {
				testTre(counter, worstReg);
				counter = 0;
				worstReg = twoReg;
			} else {
				counter++;
			}
			if (counter == 100) {
				break;
			}
		}
		testTre(counter, worstReg);
		return worstReg;
	}

	private void testTre(int a, int b) {
		System.out.println("Counter: " + a + "      " + "Best amount of cash registers:  " + b);
	}

	private void testTvå(int a) {
		System.out.println("Missed customers: " + a);
	}

	private void test1() {
		System.out.println("HERRO");
	}
}
