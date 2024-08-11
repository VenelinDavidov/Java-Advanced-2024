package Lab_Streams_Files_And_Directories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        List<String> lines = Files.readAllLines(Paths.get(path))
                .stream()
                .sorted()
                .collect(Collectors.toList());

        Files.write(Paths.get("output.txt06"), lines);

    }
}
