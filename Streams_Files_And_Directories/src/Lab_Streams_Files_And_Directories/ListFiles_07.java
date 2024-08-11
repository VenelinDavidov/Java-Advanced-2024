package Lab_Streams_Files_And_Directories;

import java.io.*;

public class ListFiles_07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Keep this file in the same directory as the project
        String path = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Streams-and-Files";

        File file = new File(path);

        File[] files = file.listFiles();

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

        // Files may not be present so check for null first
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory()) {
                    writer.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }
        writer.close();
    }
}
