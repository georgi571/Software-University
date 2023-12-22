package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.File;
import java.util.ArrayDeque;

public class _08NestedFolders {
    public static void main(String[] args) {
        File root = new File("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\FilesAndStreams");
        int count = 0;
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            File file = queue.poll();
            File[] files = file.listFiles();
            System.out.printf("%s%n", file.getName());
            count++;
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }
        }
        System.out.printf("%d folders", count);
    }
}
