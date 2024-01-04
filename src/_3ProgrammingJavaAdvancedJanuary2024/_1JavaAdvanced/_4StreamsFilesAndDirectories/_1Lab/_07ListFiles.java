package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.File;

public class _07ListFiles {
    public static void main(String[] args) {
        File folder = new File("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\FilesAndStreams");
        if (folder.exists()) {
            if (folder.isDirectory()) {
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%s]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}
