
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

	public View view = new View();
	
	public RunConfig(String[] args) {
		if(args.length == 10) {
			int i = 0;
			seed = Integer.parseInt(args[i++]);
			regLimit = Integer.parseInt(args[i++]);
			CLimit = Integer.parseInt(args[i++]);
			
			lambda = Double.parseDouble(args[i++]);
			closingTime = Double.parseDouble(args[i++]);
			pMin= Double.parseDouble(args[i++]);
			pMax= Double.parseDouble(args[i++]);
			kMin= Double.parseDouble(args[i++]);
			kMax= Double.parseDouble(args[i++]);
			
			addView(Boolean.parseBoolean(args[i]));
		}
	}
	
	public void addView(boolean output) {
		if(output) {
			view = new SuperMarketConsole(this);
		} else {
			view = new SuperMarketFile();
		}
	}
}
