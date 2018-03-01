package be.axxes.hashcode.domain;

import java.util.List;

public class Car {

    private Location currentPosition;
    private boolean available;
    private int lengthOfRide;
    private List<Ride> rideHistory;

    public Location getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Location currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isAvailable() {
        return lengthOfRide >= 0;
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
    public String toString() {
        return "Car{" +
                "currentPosition=" + currentPosition +
                ", available=" + available +
                ", lengthOfRide=" + lengthOfRide +
                ", rideHistory=" + rideHistory +
                '}';
    }
}
