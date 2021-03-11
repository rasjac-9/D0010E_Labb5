package Lab5;

public class RunSim {

	static String[] str1 = {"1234", "2", "5", "1.0", "10.0", "0.5", "1.0", "2.0", "3.0", "true"};
	static String[] str2 = {"13", "2", "7", "3.0", "8.0", "0.6", "0.9", "0.35", "0.6", "true"};
	
	public static void main(String[] args) {
		if (args[0].equals("1")) {
			Simulation sim = new Simulation(str1);
		} else {
			Simulation sim = new Simulation(str2);
		}
		
	}
	
}
