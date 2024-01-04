package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class _06WordCount {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> words = new HashMap<>();
        BufferedReader reader1 = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\words.txt"));
        BufferedReader reader2 = Files.newBufferedReader(Path.of("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\text.txt"));
        BufferedWriter writer = Files.newBufferedWriter(Path.of("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\result.txt"));
        String line = reader1.readLine();
        while (line != null) {
            String[] lineArray = line.split("\\s+");
            for (int i = 0; i < lineArray.length; i++) {
                words.put(lineArray[i], 0);
            }
            line = reader1.readLine();
        }
        line = reader2.readLine();
        while (line != null) {
            String[] lineArray = line.split("\\s+");
            for (int i = 0; i < lineArray.length; i++) {
                if (words.containsKey(lineArray[i])) {
                    words.put(lineArray[i], words.get(lineArray[i]) + 1);
                }
            }
            line = reader2.readLine();
        }
        words.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(entry -> {
                    try {
                        writer.write(String.format("%s - %d%n", entry.getKey(), entry.getValue()));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        reader1.close();
        reader2.close();
        writer.close();
    }
}
