package knifflor;

import java.util.Arrays;

public class Player {
	
	
	
	Result rollDices(int nOfDices, int nOfSides) {
		
		int[] result = new int[nOfDices];
		Dice d = new Dice(nOfSides);
		
		for(int i=0;i<nOfDices;i++) {
			result[i] = d.roll();
		}
		
		
		return new Result(result,nOfSides);
	}
	
	
	
	
	
	
		

}
