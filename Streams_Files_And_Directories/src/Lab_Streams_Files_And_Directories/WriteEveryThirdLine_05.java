package Lab_Streams_Files_And_Directories;

import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        // Keep this file in the same directory as the project
        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt05");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        String line = reader.readLine();
        int counter = 1;
        while (line != null) {

            if (counter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            counter++;
            line = reader.readLine();
        }
        writer.close();
    }
}