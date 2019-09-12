package knifflor;

import java.util.Arrays;

public class Player {
	
	
	public Dice dice;
	
	public Player(Dice d) {
		super();
		this.dice = d;
	}


	
	Result rollDices(int nOfDices) {
		
		int[] result = new int[nOfDices];
		
		for(int i=0;i<nOfDices;i++) {
			result[i] = dice.roll();
		}
		
		
		return new Result(result,this.dice.getSides());
	}
	
	
	
	
	
	
	Result rerollDice(Result r, int diceIndex) {
		
		return r.replaceDice(diceIndex, this.dice.roll());
		
		
}
}
