package decorator;

public class CarFactory {
	
	public CarType getCar(String car) {
		if(car == null) {
			return null;
		}
		if(car.equalsIgnoreCase("Truck")) {
			return new Truck();
		}
		if(car.equalsIgnoreCase("Sedan")) {
			return new Sedan();
		}
		if(car.equalsIgnoreCase("Van")) {
			return new Van();
		}
		
		return null;
	}

}
