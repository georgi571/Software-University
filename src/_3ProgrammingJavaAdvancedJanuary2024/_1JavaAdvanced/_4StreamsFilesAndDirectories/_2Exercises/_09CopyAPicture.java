package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09CopyAPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\Flag_of_Bulgaria.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\Copy_Flag_of_Bulgaria.jpg");
        int readByte = fileInputStream.read();
        while (readByte != -1) {
            fileOutputStream.write(readByte);
            readByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
