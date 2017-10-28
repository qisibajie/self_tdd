package iris.tdd.parklot.boy;

import iris.tdd.parklot.behavior.impl.NormalPickUpCar;
import iris.tdd.parklot.behavior.impl.SequenceParking;

public class ParkingBoy extends BaseParkingBoy {

    public ParkingBoy() {
        parkBehavior = new SequenceParking();
        pickUpBehavior = new NormalPickUpCar();
    }
}