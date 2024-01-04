package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _01SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\input.txt"));
        String line = reader.readLine();
        while (line != null) {
            char[] chars = line.toCharArray();
            long sum = 0;
            for (char c : chars) {
                sum += c;
            }
            System.out.printf("%d%n", sum);
            line = reader.readLine();
        }
        reader.close();
    }
}
