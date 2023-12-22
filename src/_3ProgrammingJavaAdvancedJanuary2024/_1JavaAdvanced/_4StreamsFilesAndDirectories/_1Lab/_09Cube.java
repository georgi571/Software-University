package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.*;

public class _09Cube {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube("blue", 1, 5, 6);
        //serialization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\cubeInfo.ser"));
        objectOutputStream.writeObject(cube);
        objectOutputStream.close();
        //deserialization
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\cubeInfo.ser"));
        Cube cube1 = (Cube) objectInputStream.readObject();
        System.out.println();;
    }
}
