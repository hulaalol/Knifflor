package knifflor;

public class Dice {
	private int sides;
	private int value;
 
 public Dice(int sides) {
	 this.sides = sides;
 }
 
 void setValue(int x){
	 if(x<=sides && x>0) {
		 this.value = x;
	 }else {
		 System.out.print("Invalid dice value - set to 0!");
		 this.value = 0;
	 }

 }
 
 int getValue() {
	 return this.value;
 }
 
 int roll() {
	 int value = (int) Math.ceil(Math.random()*(sides));
	 this.setValue(value);
	 return value;
 }
 
}
