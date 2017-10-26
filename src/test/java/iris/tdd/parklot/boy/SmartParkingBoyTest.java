package iris.tdd.parklot.boy;

import iris.tdd.parklot.Car;
import iris.tdd.parklot.ParkingTicket;
import iris.tdd.parklot.exception.NoAvailableParkingSpacesException;
import iris.tdd.util.BaseParkingBoyTool;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SmartParkingBoyTest {

	@Test
	public void should_return_ticket_When_given_one_available_spaces_parking_lot() {
		//given
		int[] parkedCars = {0};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(1, parkedCars);
		Car car = new Car("B1");
		//when
		ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
		//then
		assertEquals("P1-TB1", parkingTicket.getTicketNo());
	}

	@Test(expected = NoAvailableParkingSpacesException.class)
	public void should_return_exception_When_given_one_unavailable_spaces_parking_lot() {
		//given
		int[] parkedCars = {100};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(1, parkedCars);
		Car car = new Car("B1");
		//when
		smartParkingBoy.parkCar(car);
	}

	@Test
	public void should_return_ticket_When_given_two_available_spaces_parking_lots() {
		//given
		int[] parkedCars = {0, 0};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(2, parkedCars);
		Car car = new Car("B1");
		//when
		ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
		//then
		assertEquals("P1-TB1", parkingTicket.getTicketNo());
	}

	@Test
	public void should_return_Aticket_When_given_two_available_spaces_parking_lot_Awith_30_parkedcars_Bwith_40_parked_cars() {
		//given
		int[] parkedCars = {30, 40};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(2, parkedCars);
		Car car = new Car("A101");
		//when
		ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
		//then
		assertEquals("P1-TA101", parkingTicket.getTicketNo());
	}

	@Test
	public void should_return_Bticket_When_given_two_available_spaces_parking_lot_Awith_40_parkedcars_Bwith_30_parked_cars() {
		//given
		int[] parkedCars = {40, 30};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(2, parkedCars);
		Car car = new Car("A101");
		//when
		ParkingTicket parkingTicket = smartParkingBoy.parkCar(car);
		//then
		assertEquals("P2-TA101", parkingTicket.getTicketNo());
	}

	@Test(expected = NoAvailableParkingSpacesException.class)
	public void should_return_exception_When_given_two_unavailable_spaces_parking_lots() {
		//given
		int[] parkedCars = {100, 100};
		SmartParkingBoy smartParkingBoy = initSmartParkingBoy(2, parkedCars);
		Car car = new Car("A101");
		//when
		smartParkingBoy.parkCar(car);
	}



	private SmartParkingBoy initSmartParkingBoy(int masteredParkingLotNum, int[] parkedCar) {

		SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
		BaseParkingBoyTool.initBaseParkingBoy(masteredParkingLotNum, parkedCar, smartParkingBoy);
		return smartParkingBoy;
	}


}
