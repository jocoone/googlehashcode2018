package be.axxes.hashcode.domain;

import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car> {

    private int id;
    private Location currentPosition;
    private boolean available;
    private int lengthOfRide;
    private List<Ride> rideHistory;

    public Car(int id) {
        this.rideHistory =new ArrayList<>();
        this.available = true;
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
        return available;
    }

    public int getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
    public int compareTo(Car o) {
        return this.getId() - o.getId();
    }
}
