package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class _05WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\05.WriteEveryThirdLineOutput.txt");
        Scanner scanner = new Scanner(fileInputStream);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        int count = 1;
        String line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            if (count % 3 == 0) {
                writer.println(line);
            }
            count++;
            line = scanner.nextLine();
        }
        scanner.close();
        writer.close();
    }
}
