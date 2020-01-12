package examples.lambdas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LambdasTestingClass {

	@Test
	void findCompactCarsTest() {
		Utils.printSeparator();
		Utils.printTestName("findCompactCarsTest");
		 List listOfCompactCars =findCompactCars(Utils.getCars());
		// List listOfCompactCars =findCompactCarsLambda(Utils.getCars());
		//List listOfCompactCars = findCars(Utils.getCars(), car -> car.getType().equals(CarTypes.COMPACT));
		listOfCompactCars.forEach(System.out::println);
		Assertions.assertTrue(listOfCompactCars.size() == 3, "");
	}

	@Test
	void findCarsThatCosts20KTest() {
		Utils.printSeparator();
		Utils.printTestName("findCarsThatCosts20K");
		 List listOfCompactCars =findCarsThatCosts20K(Utils.getCars());
		//List listOfCompactCars = findCarsThatCosts20KLambda(Utils.getCars());
		 //List listOfCompactCars =findCars(Utils.getCars(),car -> car.getCostUSD() > 20000);
		listOfCompactCars.forEach(System.out::println);
		Assertions.assertTrue(listOfCompactCars.size() == 4, "");
	}

	// Obtiene todos los carros que sean de tipo compacto compactos
	List<Car> findCompactCars(List<Car> cars) {
		List<Car> compactCars = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getType().equals(CarTypes.COMPACT)) {
				compactCars.add(car);
			}
		}
		return compactCars;
	}

	List<Car> findCarsThatCosts20K(List<Car> cars) {
		List<Car> twentyKCars = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getCostUSD() > 20000) {
				twentyKCars.add(car);
			}
		}
		return twentyKCars;
	}

	// Obtiene todos los carros que sean de tipo compacto compactos
	List<Car> findCompactCarsLambda(List<Car> cars) {
		List<Car> compactCars = cars.stream().filter(car -> car.getType().equals(CarTypes.COMPACT))
				.collect(Collectors.toList());
		return compactCars;
	}

	List<Car> findCarsThatCosts20KLambda(List<Car> cars) {
		List<Car> twentyKCars = cars.stream().filter(car -> car.getCostUSD() > 20000).collect(Collectors.toList());
		return twentyKCars;
	}

	// Obtiene todos los carros que sean de tipo compacto compactos
	List<Car> findCars(List<Car> cars,Predicate<Car> condition) {
		List<Car> foundCars = cars.stream().filter(condition)
				.collect(Collectors.toList());
		return foundCars;
	}

}
