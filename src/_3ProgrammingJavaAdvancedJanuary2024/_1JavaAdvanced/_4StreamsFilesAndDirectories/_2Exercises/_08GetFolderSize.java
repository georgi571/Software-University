package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.File;

public class _08GetFolderSize {
    public static void main(String[] args) {
        File directory = new File("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\Exercises Resources");
        long size = 0;
        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                for (File file : files) {
                    if (!file.isDirectory()) {
                        size += file.length();
                    }
                }
            }
        }
        System.out.printf("Folder size: %d", size);
    }
}
