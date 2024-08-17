package Lab_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {

            String next = scanner.nextLine();

            next = next.replaceAll("[,.!?]", "");
            for (int i = 0; i < next.length(); i++) {
                outputStream.write(next.charAt(i));
            }
            String lineSeparator = System.lineSeparator();
            for (int i = 0; i < lineSeparator.length(); i++) {
                outputStream.write(lineSeparator.charAt(i));
            }
        }
        outputStream.close();
    }
}
