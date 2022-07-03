package decorator;

public class CarSkinBlue extends CarDecorator{

	public CarSkinBlue(CarType decoratedCar) {
		super(decoratedCar);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void drive() {
		decoratedCar.drive();
		setCarColorBlue(decoratedCar);
	}

	private void setCarColorBlue(CarType decoratedCar) {
		System.out.println("CarColor: Blue");
	}
}