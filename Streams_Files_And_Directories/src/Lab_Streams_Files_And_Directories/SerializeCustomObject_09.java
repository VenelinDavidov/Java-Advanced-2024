package Lab_Streams_Files_And_Directories;

import java.io.*;

public class SerializeCustomObject_09 {

public static class Cube implements Serializable {

    String color;
    double width;
    double height;
    double depth;

}

    public static void main(String[] args) throws IOException, ClassNotFoundException {

    Cube cube  = new Cube();

    cube.color = "green";
    cube.width = 15.3;
    cube.height = 42;
    cube.depth = 3;


       ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ice_cube.txt"));

       objectOutputStream.writeObject(cube);

       ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ice_cube.txt"));

       Cube iceCube = (Cube) objectInputStream.readObject();

    }
}
