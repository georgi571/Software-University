package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab._Lab;

import java.io.FileInputStream;
import java.io.IOException;

public class _01ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fileStream = new FileInputStream("D:\\SoftwareUniversity\\Softrware-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_1Lab\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        int currentByte = fileStream.read();
        while (currentByte >= 0) {
            System.out.printf("%s ", Integer.toBinaryString(currentByte));
            currentByte = fileStream.read();
        }
        fileStream.close();
    }
}
