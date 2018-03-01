package be.axxes.hashcode;

import be.axxes.hashcode.domain.Car;
import be.axxes.hashcode.domain.Location;
import be.axxes.hashcode.domain.Ride;
import be.axxes.hashcode.service.Service;
import be.axxes.hashcode.utils.FileUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // R
    static int rows;
    // C
    static int colums;
    // F
    static int fleet;
    // N
    static int rides;
    // B
    static int bonus;
    // T
    static int steps;

    static List<Ride> rideList;


    public static void main(String[] args) throws IOException {
        final List<String> example = FileUtils.readLines("example.in");
        final List<String> b = FileUtils.readLines("b_should_be_easy.in");
        final List<String> c = FileUtils.readLines("c_no_hurry.in");
        final List<String> d = FileUtils.readLines("d_metropolis.in");
        final List<String> e = FileUtils.readLines("e_high_bonus.in");
        parseFile(example, "example.out");
        parseFile(b, "b_should_be_easy.out");
        parseFile(c, "c_no_hurry.out");
        parseFile(d, "d_metropolis.out");
        parseFile(e, "e_high_bonus.out");
    }

    private static void parseFile(List<String> test, String output) throws IOException {
        String[] args = test.get(0).split(" ");
        rows = Integer.parseInt(args[0]);
        colums = Integer.parseInt(args[1]);
        fleet = Integer.parseInt(args[2]);
        rides = Integer.parseInt(args[3]);
        bonus = Integer.parseInt(args[4]);
        steps = Integer.parseInt(args[5]);

        System.out.println("Rows: " + rows);
        System.out.println("Colums: " + colums);
        System.out.println("Fleet: " + fleet);
        System.out.println("Rides: " + rides);
        System.out.println("Bonus: " + bonus);
        System.out.println("Steps: " + steps);

        rideList = parseSecondLine(test.subList(1, test.size()));
        Collections.sort(rideList);

        int step = 0;
        int rideCounter = 0;
        Service service = new Service();
        service.setRides(rideList);
        List<Car> cars = new ArrayList<>();
        int c = 0;
        while (c < fleet) {
            cars.add(new Car(c + 1));
            c++;
        }
        service.setCars(cars);
        Map<Integer, List<Integer>> driven = new HashMap<>();

        while (step < steps) {
            for (Car car : service.getCars()) {
                car.decreaseRideLength();
            }
            List<Car> availableCars = service.getAvailableCars();

            for (Car car : availableCars) {
                if (car.isAvailable()) {
                    for (Ride ride : rideList) {
                        if (ride.isNotCompleted()) {
                            int length = car.getCurrentPosition().calculateDistance(ride.getStart()) + ride.getStart().calculateDistance(ride.getStop());
                            if (steps - step < length || ride.getLatestArrival() < (step - length)) {
                                ride.setNotCompleted(false);
                                break;
                            }
                            int result = length - ride.getEarliestStart();

                            if (result <= ride.getLatestArrival()) {
                                service.assignToCar(ride, car);
                                break;
                            }
                        }
                    }
                }
            }


            step++;
        }


        writeRides(service.getCars(), output);
    }


    private static void writeRides(final List<Car> cars, String output) throws IOException {
        int i = 1;
        final List<String> result = new ArrayList<>();
        Collections.sort(cars);
        for (Car car : cars) {
            result.add("" + car.getRideHistory().size() + " " + car.getRideHistory().stream().map(Ride::getId).map(r -> "" + r).collect(Collectors.joining(" ")));
        }
        FileUtils.writeFile(result, output);
    }

    private static List<Ride> parseSecondLine(List<String> lines) {
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
            ride.setId(i);
            rides.add(ride);

        }

        System.out.println("# rides: " + rides.size());

        return rides;
    }
}
