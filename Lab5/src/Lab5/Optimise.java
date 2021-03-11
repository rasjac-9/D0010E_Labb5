
package Lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Optimise {
	//static String[] str1 = {"1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "false"};
	static String[] str2 = {"13", "2", "7", "3.0", "8.0", "0.6", "0.9", "0.35", "0.6", "false"};

	Optimise() {
		slutTillstånd();
	}
	/**
	 * The class runs a simulation and stores
	 * the output values of the simulation in
	 * an array
	 *
	 * @author Alex Bergdahl,
	 * @author Kim Eriksson,
	 * @author Peggy Khialie,
	 * @author Rasmus Jacobsen
	 *
	 */
	public ArrayList slutTillstånd() {

		ArrayList<Double> values = new ArrayList<>();

		try {

			File file = new File("optimization.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				values.add(parseDouble(reader.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(values);
		return values;
	}

	public void metod2(String[] str) {
		String[] str1 = {"1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "false"};
		for(int i = 0; i < parseInt(str[2]); i++) {

		}
	}
}
