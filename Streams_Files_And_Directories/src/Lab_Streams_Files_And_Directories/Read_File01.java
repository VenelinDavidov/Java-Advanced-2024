package Lab_Streams_Files_And_Directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read_File01 {
    public static void main(String[] args) throws IOException {

// Keep this file in the same directory as the project

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int asciiCode = inputStream.read();

        while (asciiCode != -1) {
            System.out.print(Integer.toBinaryString(asciiCode) + " ");
            asciiCode = inputStream.read();
        }
    }
}
