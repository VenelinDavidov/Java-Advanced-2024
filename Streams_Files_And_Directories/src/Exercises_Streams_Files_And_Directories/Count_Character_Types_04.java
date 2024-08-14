package Exercises_Streams_Files_And_Directories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Count_Character_Types_04 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\input.txt";

        String content = Files.readString(Path.of(path));
        content = content.replaceAll("\\s+", "");

        int countVowels = 0;
        int countPunctuations = 0;
        int countOthers = 0;

        for (char symbol : content.toCharArray()) {

            if (isVowel(symbol)) {
                countVowels++;
            } else if (isPunctuation(symbol)) {
                countPunctuations++;
            } else {
                countOthers++;
            }
        }

        PrintWriter writer = new PrintWriter("output.txt04");
        writer.println("Vowels: " + countVowels);
        writer.println("Other symbols: " + countOthers);
        writer.println("Punctuation: " + countPunctuations);
        writer.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '?' || symbol == '.' || symbol == ',';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}