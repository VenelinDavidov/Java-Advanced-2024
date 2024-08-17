package Lab_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.IOException;

public class Read_File01 {
    public static void main(String[] args) throws IOException {

        // Keep this file in the same directory as the project
        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int asciiCode = inputStream.read();

        while (asciiCode != -1) {
            System.out.print(Integer.toBinaryString(asciiCode) + " ");
            asciiCode = inputStream.read();
        }
    }
}