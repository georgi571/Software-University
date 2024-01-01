package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._2Exercises;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String path1 = "D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\input.txt";
        String path2 = "D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\inputLineNumbers.txt";
        String path3 = "D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\inputOne.txt";
        List<String> paths = List.of(path1, path2, path3);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\JavaAdvancedFilesAndStreamsExercisesResources\\files.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
        for (String path : paths) {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            int read = fileInputStream.read();
            while (read != -1) {
                zipOutputStream.write(read);
                read = fileInputStream.read();
            }
            fileInputStream.close();
        }
        zipOutputStream.close();
        fileOutputStream.close();
    }
}
