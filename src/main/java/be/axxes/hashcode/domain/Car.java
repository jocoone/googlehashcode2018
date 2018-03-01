package be.axxes.hashcode.domain;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private int id;
    private Location currentPosition;
    private int lengthOfRide;
    private List<Ride> rideHistory;

    public Car(int id) {
        this.rideHistory =new ArrayList<>();
        this.currentPosition = new Location("0", "0");
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Location currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isAvailable() {
        return lengthOfRide <= 0;
    }

    public int getId() {
        return id;
    }

    public int getLengthOfRide() {
        return lengthOfRide;
    }

    public void setLengthOfRide(int lengthOfRide) {
        this.lengthOfRide = lengthOfRide;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(List<Ride> rideHistory) {
        this.rideHistory = rideHistory;
    }

    public void decreaseRideLength() {
        if (lengthOfRide > 0)
            lengthOfRide--;
    }

    @Override
    public String toString() {
        return "Car{" +
                "currentPosition=" + currentPosition +
                ", lengthOfRide=" + lengthOfRide +
                ", rideHistory=" + rideHistory +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getId() - o.getId();
    }


}
