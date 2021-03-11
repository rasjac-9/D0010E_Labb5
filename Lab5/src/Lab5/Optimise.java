
package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Optimise {
	static String[] str1 = {"1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "false"};
	static String[] str2 = {"13", "2", "7", "3.0", "8.0", "0.6", "0.9", "0.35", "0.6", "false"};

	Optimise() {
		int[] str1 = {1234, 2, 5};
		opti(new RunConfig(str1));
	}
	/**
	 * The method runs a simulation and stores
	 * the output values of the simulation in
	 * an array
	 *
	 * @author Alex Bergdahl,
	 * @author Kim Eriksson,
	 * @author Peggy Khialie,
	 * @author Rasmus Jacobsen
	 *
	 */
	public ArrayList slutTillstånd(int[] args) {

		ArrayList<Double> values = new ArrayList<>();
		new Simulation(args);

		try {

			File file = new File("optimization.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				values.add(parseDouble(reader.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return values;
	}


	/**
	 * The metod that finds the optimal amount
	 * of registers depending on max customers
	 * and lost customers
	 *
	 * @author Alex Bergdahl,
	 * @author Kim Eriksson,
	 * @author Peggy Khialie,
	 * @author Rasmus Jacobsen
	 *
	 */
	public int opti(RunConfig rc) {

		int[] configs = {rc.seed, 1, rc.CLimit};
		int Climit = 0;

		double lowest = Integer.MAX_VALUE;
		for(int i = 1; i < rc.CLimit; i++) {
			configs[1] = i;
			ArrayList<Double> values = slutTillstånd(configs);

			if(lowest > values.get(0)) {
				lowest = values.get(0);
				Climit = i;
			} else {
				break;
			}
		}
		int x = (int) Math.round(lowest);
		//int [] k = {x,Climit};
		//System.out.println("Minsta antal kassor som ger minimalt antal missade ("+x+"): "+Climit);
		return Climit;
	}

	public metod3() {
		Random rand = new Random();
		int counter = 100;
		while(counter > 0){
			int[] x = {rand.nextInt(), 1, 5};
			RunConfig rc = new RunConfig(x);

			opti(rc);

		}
	}
}
