package iris.tdd.parklot.boy;

import iris.tdd.parklot.behavior.impl.MaxLeftSpacesParking;
import iris.tdd.parklot.behavior.impl.NormalPickUpCar;

public class SmartParkingBoy extends BaseParkingBoy {

	public SmartParkingBoy() {
		parkBehavior = new MaxLeftSpacesParking();
		pickUpBehavior = new NormalPickUpCar();
	}
}
