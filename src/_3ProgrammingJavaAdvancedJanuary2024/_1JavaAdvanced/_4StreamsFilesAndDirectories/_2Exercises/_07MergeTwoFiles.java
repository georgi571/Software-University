package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\inputOne.txt"));
        BufferedReader reader2 = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\inputTwo.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Path.of("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\Exercises Resources\\output7.txt"));
        String line = reader1.readLine();
        while (line != null) {
            writer.write(String.format("%s%n", line));
            line = reader1.readLine();
        }
        line = reader2.readLine();
        while (line != null) {
            writer.write(String.format("%s%n", line));
            line = reader2.readLine();
        }
        reader1.close();
        reader2.close();
        writer.close();
    }
}
