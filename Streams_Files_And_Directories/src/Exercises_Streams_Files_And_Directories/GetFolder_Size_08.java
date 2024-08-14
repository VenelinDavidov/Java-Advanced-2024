package Exercises_Streams_Files_And_Directories;

import java.io.File;

public class GetFolder_Size_08 {
    public static void main(String[] args) {


        String folderPath = "C:\\Users\\VITORIYA\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources" +
                "\\Exercises Resources";


        int size = 0;
        File folder = new File(folderPath);

        for (File file : folder.listFiles()) {
            size += file.length();
        }

        System.out.println("Folder size: " + size);
    }
}
