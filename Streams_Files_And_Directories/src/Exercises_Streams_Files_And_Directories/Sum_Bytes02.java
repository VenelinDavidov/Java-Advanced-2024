package Exercises_Streams_Files_And_Directories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Sum_Bytes02 {
    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources\\Exercises Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        Scanner scanner = new Scanner(new FileReader(path));

        //НАЧИН 1: BufferedReader
        int sum = 0;
        String line = reader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = reader.readLine();
        }


        //НАЧИН 2: Scanner
//        while (scanner.hasNextLine()) {
//            String line2 = scanner.nextLine();
//            for (char symbol : line2.toCharArray()) {
//                sum += symbol;
//            }
//        }

        System.out.println(sum);
    }
}
