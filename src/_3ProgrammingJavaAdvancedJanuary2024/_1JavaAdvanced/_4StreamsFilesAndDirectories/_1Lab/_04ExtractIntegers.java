package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.*;
import java.util.Scanner;

public class _04ExtractIntegers {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\input.txt");
        Scanner scanner = new Scanner(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\04.ExtractIntegersOutput.txt");
        PrintWriter writer = new PrintWriter(fileOutputStream);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }
        fileInputStream.close();
        writer.close();
    }
}
