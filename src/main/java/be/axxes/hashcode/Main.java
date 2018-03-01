package be.axxes.hashcode;

import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;
import be.axxes.hashcode.utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> lines = FileUtils.readLines("a_example.in");

        List<Ride> rides = new Main().parseOtherLines(lines);

        List<String> output = createOutput(rides);
        FileUtils.writeFile(output, "example.out");
    }

    private static List<String> createOutput(List<Ride> rides) {
        List<String> output = new ArrayList<>();
        for (Ride ride : rides) {
            output.add(ride.toString());
        }
        return output;
    }


    private List<Ride> parseOtherLines(List<String> lines) {
        List<Ride> rides = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String[] split = lines.get(i).split(" ");

            Location start = new Location(split[0], split[1]);
            Location stop = new Location(split[2], split[3]);

            int earliestStart = Integer.parseInt(split[4]);
            int latestArrival = Integer.parseInt(split[5]);

            Ride ride = new Ride();
            ride.setEarliestStart(earliestStart);
            ride.setLatestArrival(latestArrival);
            ride.setStart(start);
            ride.setStop(stop);
            rides.add(ride);

        }
        return rides;
    }
}
