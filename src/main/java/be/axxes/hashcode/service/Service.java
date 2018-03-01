package be.axxes.hashcode.service;

import be.axxes.hashcode.domain.Car;
import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;

import java.util.ArrayList;
import java.util.List;

public class Service {

    List<Car> cars = new ArrayList<>();
    List<Ride> rides = new ArrayList<>();


    public List<Car> getAvailableCars() {

        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable())
                availableCars.add(car);
        }
        return availableCars;

    }

    public Location getPositionOfCar(Car car) {
        return car.getCurrentPosition();
    }


    public void assignToCar(Ride ride, Car car) {

        rides.remove(ride);

        car.setAvailable(false);
        car.setLengthOfRide(ride.getStart().calculateDistance(ride.getStop()));

        car.getRideHistory().add(ride);

    }


}
