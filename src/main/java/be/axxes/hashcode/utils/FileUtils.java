package be.axxes.hashcode.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final String BASE_PATH = System.getProperty("user.dir") + File.separator + "/files/";

    public static List<String> readLines(final String file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + "/in/" + file))) {
            final List<String> lines = new ArrayList<>();
            String line = br.readLine();

            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
            return lines;
        }
    }

    public static String readFile(final String file) throws IOException {
        final StringBuilder sb = new StringBuilder();
        for (String line : readLines(file)) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void writeFile(final List<String> lines, final String filename) throws IOException {
        try (final BufferedWriter bw = new BufferedWriter(new FileWriter(BASE_PATH + "/out/" + filename))) {
            for (String line : lines) {
                bw.write(line);
                bw.write(System.lineSeparator());
            }
        }
    }
}
