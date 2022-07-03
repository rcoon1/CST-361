package decorator;

public abstract class CarDecorator {

	protected CarType decoratedCar;
	
	public CarDecorator(CarType decoratedCar) {
		this.decoratedCar = decoratedCar;
	}
	
	public void drive() {
		decoratedCar.drive();
	}
	
}
