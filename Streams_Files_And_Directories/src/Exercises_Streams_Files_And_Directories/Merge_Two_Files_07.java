package Exercises_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Merge_Two_Files_07 {
    public static void main(String[] args) throws IOException {


        String firstFileContent = Files.readString(Path.of("C:\\Users\\VITORIYA\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputOne.txt"));

        String secondFileContent = Files.readString(Path.of("C:\\Users\\VITORIYA\\Downloads" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\inputTwo.txt"));


        PrintWriter printWriter = new PrintWriter("output.txt07");
        printWriter.println(firstFileContent);
        printWriter.println(secondFileContent);
        printWriter.close();
    }
}
