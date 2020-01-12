package examples.lambdas;

import java.util.ArrayList;
import java.util.List;

public interface Utils {

	public static List getCars() {
		ArrayList<Car> carList=new ArrayList<>();
		carList.add(new Car("1",10000,"rojo",CarTypes.COMPACT));
		carList.add(new Car("2",50000,"verde",CarTypes.TRUCK));
		carList.add(new Car("3",10000,"azul",CarTypes.TRUCK));
		carList.add(new Car("4",15000,"rojo",CarTypes.SUV));
		carList.add(new Car("5",60000,"rojo",CarTypes.SUV));
		carList.add(new Car("6",30000,"negro",CarTypes.SUV));
		carList.add(new Car("7",30000,"rojo",CarTypes.COMPACT));
		carList.add(new Car("8",5000,"verde",CarTypes.COMPACT));
		carList.add(new Car("9",7000,"grafito",CarTypes.SUV));
		carList.add(new Car("10",8000,"rojo",CarTypes.TRUCK));
		return carList;
	}
	public static void printSeparator() {
		System.out.println("*******************************");
	}
	
	public static void printTestName(String name) {
		System.out.println("*   "+name+"   *");
	}

}
