package Exercises_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Line_Numbers05 {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter printWriter = new PrintWriter("output.txt5");

        int counter = 1;
        for (String line : lines) {
            String  output = String.format("%d. %s",counter, line );
            counter++;
            printWriter.println(output);
        }
       printWriter.close();

    }
}
