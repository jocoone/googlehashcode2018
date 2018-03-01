package be.axxes.hashcode;

import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        final List<String> lines = FileUtils.readLines("example.in");
//        FileUtils.writeFile(lines, "example.out");



        Ride ride=this.parseSecondLine(="0 0 1 3 2 9")
    }

    String line ="0 0 1 3 2 9";

    Ride parseSecondLine(String line) {
        String[] split = line.split(" ");

        for (int i = 0; i < split.length; i++) {
            Location start = new Location(split[0], split[1]);
            Location stop = new Location(split[2], split[3]);

            int earliestStart = Integer.parseInt(split[4]);
            int latestArrival = Integer.parseInt(split[5]);

            Ride ride=new Ride();
            ride.setEarliestStart(earliestStart);
            ride.setLatestArrival(latestArrival);
            ride.setStart(start);
            ride.setStop(stop);

        }

    }
}
