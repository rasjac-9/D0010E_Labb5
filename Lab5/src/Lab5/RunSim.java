
package Lab5;

import Lab5.view.SuperMarketConsole;

public class RunSim implements K {

	static int[] str1 = {1234, 2, 5};
	static int[] str2 = {13, 2, 7};
	
	public static void main(String[] args) {
		Simulation nice = new Simulation();

		int regLimit = 2;
		nice.run(SEED, regLimit, M, L, END_TIME, LOW_COLLECTION_TIME, HIGH_COLLECTION_TIME, LOW_PAYMENT_TIME,
				HIGH_PAYMENT_TIME, true);
	}
	
}
