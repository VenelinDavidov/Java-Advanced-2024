package Exercises_Streams_Files_And_Directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Sum_Lines01 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}

