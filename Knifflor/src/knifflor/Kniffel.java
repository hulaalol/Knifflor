package knifflor;

import java.util.Arrays;

public class Kniffel {

	static Dice[] cup;
	
	public static void main(String args[]) {
		
		
		int nOfDices = 5;
		int nOfSides = 6;
		
		Player p = new Player();
		
		Result r = p.rollDices(nOfDices,nOfSides);
		
		int tries = 0;
		while(!r.isKniffel()) {
			
			r = p.rollDices(nOfDices, nOfSides);
			tries++;
		}
		
		System.out.print("Got Kniffel on first throw after "+String.valueOf(tries)+" tries!");
		System.out.println(r.toString());
		System.out.println(r.occsToString());
		
		tries = 0;
		while(!r.isFullHouse(2,3)) {
			
			r = p.rollDices(nOfDices, nOfSides);
			tries++;
		}
		
		System.out.print("Got FullHouse on first throw after "+String.valueOf(tries)+" tries!");
		System.out.println(r.toString());
		System.out.println(r.occsToString());
		
		tries = 0;
		while(!r.isSmallStreet(4)) {
			
			r = p.rollDices(nOfDices, nOfSides);
			tries++;
		}
		
		System.out.print("Got SmallStreet on first throw after "+String.valueOf(tries)+" tries!");
		System.out.println(r.toString());
		System.out.println(r.occsToString());
		
		
		tries = 0;
		while(!r.isBigStreet(5)) {
			
			r = p.rollDices(nOfDices, nOfSides);
			tries++;
		}
		
		System.out.print("Got BigStreet on first throw after "+String.valueOf(tries)+" tries!");
		System.out.println(r.toString());
		System.out.println(r.occsToString());
		
		
		
//		int nOfDices = 10000;
//		int nOfSides = 6;
//		
//		cup = new Dice[nOfDices];
//		
//		double [] occ = new double[nOfSides];
//		
//		
//		
//		for(int i=0;i<nOfDices;i++){
//			cup[i] = new Dice(nOfSides);
//			//System.out.print(i);
//			int value = cup[i].roll();
//			occ[value-1]++;
//			
//			//
//			//System.out.print(new Integer(cup[i].getValue()).toString().concat("/").concat(new Integer(occ[cup[i].getValue()-1]).toString().concat("|")));
//		
//		
//		}
//		
//		double sum = 0;
//		for(int i=0;i<occ.length;i++) {
//			occ[i] = occ[i]/nOfDices;
//			sum+=occ[i];
//		}
//		
//		System.out.println(Arrays.toString(occ));
//		System.out.println(sum);
		
		
	}
	
	
}
