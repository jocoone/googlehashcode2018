package be.axxes.hashcode.service;

import be.axxes.hashcode.domain.Car;
import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;

import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private List<Car> cars;
    private List<Ride> rides;


    public List<Car> getAvailableCars() {
        return cars.stream().filter(Car::isAvailable).collect(Collectors.toList());
    }

    public Location getPositionOfCar(Car car) {
        return car.getCurrentPosition();
    }


    public void assignToCar(Ride ride, Car car) {

        ride.setNotCompleted(false);


        ride.setNotCompleted(false);
        car.setAvailable(false);
        car.setLengthOfRide(ride.getStart().calculateDistance(ride.getStop()));

        car.getRideHistory().add(ride);

    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Ride> getRides() {
        return rides.stream().filter(Ride::isNotCompleted).collect(Collectors.toList());
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
