package factory;

public class FactoryDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarFactory factory = new CarFactory();
		
		CarType car1 = factory.getCar("Truck");
		car1.drive();
		CarType car2 = factory.getCar("Sedan");
		car2.drive();
		CarType car3 = factory.getCar("Van");
		car3.drive();
	}

}
