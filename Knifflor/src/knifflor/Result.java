package knifflor;

import java.util.Arrays;

public class Result {

	int maxValue;
	int[] values;
	int[] occs;

	public Result(int[] values, int maxValue) {
		this.values = values;
		this.maxValue = maxValue;
		this.getOccs();
	}

	public String toString() {
		return Arrays.toString(this.values);
	}

	public String occsToString() {
		return Arrays.toString(this.occs);
	}

	public int[] getOccs() {

		int[] occ = new int[this.maxValue];
		for (int i = 0; i < this.maxValue; i++) {
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
		for (int i = 0; i < this.occs.length; i++) {

			if (this.occs[i] == this.values.length) {
				// its a kniffel
				return true;
			}
		}
		return false;
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

	private boolean isStreet(int x) {
		if (streetCalc() == x) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSmallStreet(int x) {
		return this.isStreet(x);
	}

	public boolean isBigStreet(int x) {
		return this.isStreet(x);
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

}
