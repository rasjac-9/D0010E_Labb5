
package Lab5;

import Lab5.simulation.View;
import Lab5.view.SuperMarketConsole;
import Lab5.view.SuperMarketFile;

public class RunConfig {
	public int seed = 1234;
	
	public int regLimit = 2;
	public int CLimit = 5;
	
	public double lambda = 1.0; 
	public double closingTime = 10.0;
	
	public double pMin = 0.5, pMax = 1.0;
	public double kMin = 2.0, kMax = 3.0;

	/*
	public int seed = 12;
	
	public int regLimit = 2;
	public int CLimit = 7;
	
	public double lambda = 3.0; 
	public double closingTime = 8.0;
	
	public double pMin = 0.6, pMax = 0.9;
	public double kMin = 0.35, kMax = 0.6;

	*/
	
	
	public View view = new View();
	
	public RunConfig(int[] args) {
		seed = args[0];
		regLimit = args[0];
		CLimit = args[0];
	}
	
	public void addView(boolean output) {
		if(output) {
			view = new SuperMarketConsole(this);
		} else {
			view = new SuperMarketFile();
		}
	}
}
