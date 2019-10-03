package knifflor;

public class AI {

	Block block;
	Result result;
	
	
	public void chooseAction() {
		
		
	}
	
	
	
	public double p2kniffel(Result r) {
		// probability of getting kniffel
		System.out.println(1.0/r.nOfSides);
		System.out.println(r.nOfSides-(r.arrayMaxValue(r.getOccs())[0])-1);	
		return Math.pow(1.0/r.nOfSides,(r.getOccs().length-(r.arrayMaxValue(r.getOccs())[0])-1));
	}
	
	public double e4kniffel(Result r) {
		// expected points when trying to get kniffel
		int kniffEyes = r.arrayMaxValue(r.getOccs())[1]+1;
		return this.p2kniffel(r)*(50.0+5.0*kniffEyes);
	}
	
	
	
}
