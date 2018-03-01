package be.axxes.hashcode.domain;

public class Ride {

    private Location start;
    private Location stop;
    private int earliestStart;
    private int latestArrival;

    private boolean notCompleted = true;


    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getStop() {
        return stop;
    }

    public void setStop(Location stop) {
        this.stop = stop;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public void setEarliestStart(int earliestStart) {
        this.earliestStart = earliestStart;
    }

    public int getLatestArrival() {
        return latestArrival;
    }

    public void setLatestArrival(int latestArrival) {
        this.latestArrival = latestArrival;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "start=" + start +
                ", stop=" + stop +
                ", earliestStart=" + earliestStart +
                ", latestArrival=" + latestArrival +
                '}';
    }

    public boolean isNotCompleted() {
        return notCompleted;
    }

    public void setNotCompleted(boolean notCompleted) {
        this.notCompleted = notCompleted;
    }
}
