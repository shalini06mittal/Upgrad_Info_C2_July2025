package oops;

public class Traveller {

	//Bike bike = new Bike();
	//Car car;// = new Car();
	Vehicle vehicle;
	
	public Traveller(Vehicle vehicle) {
		this.vehicle = vehicle;
		// TODO Auto-generated constructor stub
	}
	


	public Vehicle getVehicle() {
		return vehicle;
	}



	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}



	public void travel() {
		//System.out.println(bike);
		vehicle.move();
	}
}
