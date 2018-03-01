package be.axxes.hashcode;

import be.axxes.hashcode.utils.FileUtils;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        final List<String> lines = FileUtils.readLines("example.in");
        FileUtils.writeFile(lines, "example.out");
    }
}
