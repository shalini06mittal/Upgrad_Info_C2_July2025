package oops;

public class Test {

	public static void main(String[] args) {
		Car car =  new Car();
		Bike bike = new Bike();
		Traveller ob = new Traveller(bike);
		//ob.setCar(car);
		ob.travel();

	}

}
