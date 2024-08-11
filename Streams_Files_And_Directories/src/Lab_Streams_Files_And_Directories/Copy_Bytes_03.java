package Lab_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Copy_Bytes_03 {
    public static void main(String[] args) throws IOException {

        // Keep this file in the same directory as the project
        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        PrintWriter writer = new PrintWriter(outputStream);

        int asciiCode = inputStream.read();

        while (asciiCode != -1) {

            if (asciiCode == ' ') {
                writer.print(" ");
            } else if (asciiCode == '\n') {
                writer.println();
            } else {
                writer.print(asciiCode);
            }
            asciiCode = inputStream.read();
        }
        writer.close();
    }
}
