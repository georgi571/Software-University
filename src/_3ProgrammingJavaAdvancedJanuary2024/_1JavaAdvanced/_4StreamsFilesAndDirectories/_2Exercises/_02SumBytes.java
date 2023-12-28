package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class _02SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\input.txt"));
        long sum = 0;
        String read = reader.readLine();
        while (read != null) {
            char[] chars = read.toCharArray();
            for (char c : chars) {
                sum += c;
            }
            read = reader.readLine();
        }
        System.out.printf("%d%n", sum);
        reader.close();
    }
}
