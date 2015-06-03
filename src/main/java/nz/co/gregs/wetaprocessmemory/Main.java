/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.wetaprocessmemory;

/**
 *
 * @author gregory.graham
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			throw new RuntimeException("No Arguments Supplied: please supply the memory available and a list of process byte consumption rates.");
		} else if (args.length == 1) {
			throw new RuntimeException("No Process Byte Consumption Rates Supplied: please supply the memory available and a list of process byte consumption rates.");
		}else{
			double memoryAvailable = Double.parseDouble(args[0]);
			double sumOfInvertedRates = 0.0d;
			for (int i = 1; i < args.length; i++) {
				String arg = args[i];
				double processByteConsumptionRate = Double.parseDouble(arg);
				sumOfInvertedRates += 1.0d/processByteConsumptionRate;
			}
			double failureTime = 1.0d/(sumOfInvertedRates/memoryAvailable);
			System.out.println(""+failureTime);
		}
	}

}
