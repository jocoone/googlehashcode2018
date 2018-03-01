package be.axxes.hashcode.service;

import be.axxes.hashcode.domain.Car;
import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Car> cars;
    private List<Ride> rides;


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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
