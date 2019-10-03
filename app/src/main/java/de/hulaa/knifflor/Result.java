package de.hulaa.knifflor;

import java.util.Arrays;

public class Result {

	int nOfSides;
	int[] values;
	int[] occs;

	public Result(int[] values, int nOfSides) {
		this.values = values;
		this.nOfSides = nOfSides;
		this.getOccs();
	}

	public Result replaceDice(int diceIndex, int value) {
		this.values[diceIndex] = value;
		this.getOccs();
		return this;
	}
	
	
	public String toString() {
		return Arrays.toString(this.values)+" /// "+ Arrays.toString(this.occs);
	}

	public String occsToString() {
		return Arrays.toString(this.occs);
	}

	public int[] getOccs() {

		int[] occ = new int[this.nOfSides];
		for (int i = 0; i < this.nOfSides; i++) {
			occ[i] = howMany(i + 1);
		}
		this.occs = occ;
		return occ;
	}

	public int howMany(int x) {
		int r = 0;
		for (int i = 0; i < this.values.length; i++) {
			if (this.values[i] == x) {
				r++;
			}
		}
		return r;
	}

	public boolean isKniffel() {
		return this.isOfKindX(5);
//		for (int i = 0; i < this.occs.length; i++) {
//
//			if (this.occs[i] == this.values.length) {
//				// its a kniffel
//				return true;
//			}
//		}
//		return false;
	}

	public boolean isFullHouse(int x, int y) {
		if (this.values.length != (x + y)) {
			System.err.print("x+y != nOfDices => No FullHouse");
			return false;
		}
		for (int i = 0; i < this.occs.length; i++) {
			if (this.occs[i] == x) {
				for (int j = 0; j < this.occs.length; j++) {
					if (i != j) {
						if (this.occs[j] == y) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	
	private boolean isOfKindX(int x) {
		for(int i=0;i<this.nOfSides;i++) {
			if(this.occs[i]==x) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isOfKind3() {
		return this.isOfKindX(3);
	}
	
	public boolean isOfKind4() {
		return this.isOfKindX(4);
	}
	

	private boolean isStreet(int x) {
		if (streetCalc() == x) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSmallStreet() {
		return this.isStreet(4);
	}

	public boolean isBigStreet() {
		return this.isStreet(5);
	}

	public int streetCalc() {
		int s = 0;
		int contender = 0;
		for (int i = 0; i < this.occs.length; i++) {
			if (this.occs[i] > 0) {
				s++;
			} else {
				contender = s;
				s = 0;
			}
		}
		return Math.max(s, contender);
	}
	
	


	// utils

	public int arraySum(int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}
	
	public int[] arrayMaxValue(int[] x) {
		int max = 0;
		int idx = 0;
		for(int i=0;i<x.length;i++) {
			if(x[i]>=max) {
				max = x[i];
				idx = i;
			}
		}
		return new int[]{max,idx};
	}

}
