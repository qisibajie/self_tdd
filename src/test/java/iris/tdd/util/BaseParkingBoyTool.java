package iris.tdd.util;

import iris.tdd.parklot.ParkingLot;
import iris.tdd.parklot.Car;
import iris.tdd.parklot.boy.BaseParkingBoy;

public class BaseParkingBoyTool {
    public static void initBaseParkingBoy(int masteredParkingLotNum, int[] parkedCar, BaseParkingBoy baseParkingBoy) {
        for (int i = 1; i <= masteredParkingLotNum; i++) {
            ParkingLot parkinglot = new ParkingLot("P" + i, 100);
            String carName = "" + (char) ('A' + i - 1);
            initParkCar(parkinglot, parkedCar[i - 1], carName);
            baseParkingBoy.addParkingLot(parkinglot);
        }
    }

    private static void initParkCar(ParkingLot parkingLot, int parkedCar, String carName) {
        for (int i = 1; i <= parkedCar; i++) {
            Car car = new Car(carName + i);
            parkingLot.parkCar(car);
        }
    }
}
