package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.*;
import java.util.List;

public class _10SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> list = List.of(4.5, 3.7, 1.0, 8.8);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\list.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        //deserializedCourse
        FileInputStream fileInputStream = new FileInputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\list.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Double> deserializedList = (List<Double>) objectInputStream.readObject();
        deserializedList.forEach(e -> System.out.printf("%s ", e));
    }
}
