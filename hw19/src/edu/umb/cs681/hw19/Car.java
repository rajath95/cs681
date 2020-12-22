package edu.umb.cs681.hw19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String make, model;
    private int mileage, year, price, dominationCount;

    public Car(String make, String model, int mileage, int year, int price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }

    public void setDominationCount(List<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            if (!car.equals(this)) {
                int price = car.getPrice();
                int year = car.getYear();
                int mileage = car.getMileage();

                if (this.getYear() >= year && this.getMileage() <= mileage && this.getPrice() <= price) {
                    if (this.getYear() > year || this.getMileage() < mileage || this.getPrice() < price) {
                        count++;
                    }
                }
            }
        }
        this.dominationCount = count;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public static void main(String args[]) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", "Model S", 20, 2018, 10000));
        cars.add(new Car("Lamborghini", "Gallardo", 100, 2019, 20000));
        cars.add(new Car("Mclaren", "F1", 200, 2015, 50000));
        cars.add(new Car("Mercedes", "V8", 50, 2020, 15000));

        cars.forEach((Car car) -> car.setDominationCount(cars));

        Integer minPrice = cars.stream()
                .parallel()
                .map((Car car) -> car.getPrice())
                .reduce(0, (result, price) -> {
                    if (result == 0) return price;
                    else if (price < result) return price;
                    else return result;
                });

        System.out.println("Min price in the list is: " + minPrice);

        Integer maxMileage = cars.stream()
                .parallel()
                .map((Car car) -> car.getMileage())
                .reduce(0, (result, mileage) -> {
                    if (result == 0) return mileage;
                    else if (mileage > result) return mileage;
                    else return result;
                });

        System.out.println("Max mileage in the list is: " + maxMileage);

        Integer numberOfCars = cars.stream()
                .parallel()
                .map((Car car) -> car.getMake())
                .reduce(0,
                        (result, make) -> ++result,
                        (finalResult, intermediateResult) -> finalResult + intermediateResult);

        System.out.println("Number of cars in the list is: " + numberOfCars);
    }
}