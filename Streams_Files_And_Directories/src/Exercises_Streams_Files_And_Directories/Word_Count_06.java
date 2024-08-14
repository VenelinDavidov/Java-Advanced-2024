package Exercises_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class Word_Count_06 {
    public static void main(String[] args) throws IOException {


        String[] words = Files.readString(Path.of("C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\words.txt")).split("\\s+");

        String text = Files.readString(Path.of("C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\text.txt"));

        Map<String, Integer> wordCount = new LinkedHashMap<>();

        for (String word : words) {
            wordCount.put(word, 0);
        }

        for (String word : text.split("\\s+")) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word) + 1;
                wordCount.put(word, count);
            }
        }
        PrintWriter printWriter = new PrintWriter("results.txt");
        wordCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        printWriter.close();
    }
}
