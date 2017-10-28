package iris.tdd.parklot.boy;

import iris.tdd.parklot.behavior.impl.MaxLeftPercentageParking;
import iris.tdd.parklot.behavior.impl.NormalPickUpCar;

public class SuperParkingBoy extends BaseParkingBoy {
	public SuperParkingBoy() {
		parkBehavior = new MaxLeftPercentageParking();
		pickUpBehavior = new NormalPickUpCar();
	}
}
