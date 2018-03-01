package be.axxes.hashcode.domain;

public class Car {

    Location currentPosition;
    boolean available;

    int lengthOfRide;

    public Location getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Location currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isAvailable() {
        return available;
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
}
