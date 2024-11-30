import airline.materials.Baggage;
import airline.materials.SamSonSuitCase;
import airline.materials.VIPLuggage;
import airline.materials.XRayMachine;

public class TestBaggage {

	public static void main(String[] args) {
		
		XRayMachine xray = new XRayMachine();
		
//		SamSonSuitCase s1 = new SamSonSuitCase();		
//		VIPLuggage v1 = new VIPLuggage();
		
		Baggage s1 = new SamSonSuitCase();		
		Baggage v1 = new VIPLuggage();
		
		xray.checkBaggage(s1);
		xray.checkBaggage(v1);
		
//		AirHostess ah1 = new AirHostess("Mala" , 50);
//		xray.checkBaggage(ah1);

	}

}

// Challenge 1: Can you develop an interface Staff that Pilot, Airhostess, ... would implement?
