package Lab5;

public class RunSim {

	static int[] str1 = {1234, 2, 5};
	static int[] str2 = {13, 2, 7};
	
	public static void main(String[] args) {
		if (args.length == 0) {
			Simulation sim = new Simulation(str1);
		} else {
			Simulation sim = new Simulation(str2);
		}
		
	}
	
}
