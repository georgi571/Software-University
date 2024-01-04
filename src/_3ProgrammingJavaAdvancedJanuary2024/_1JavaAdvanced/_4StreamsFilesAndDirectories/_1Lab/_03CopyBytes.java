package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._4StreamsFilesAndDirectories._1Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\input.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\SoftwareUniversity\\Software-University\\src\\_3ProgrammingJavaAdvancedJanuary2024\\_1JavaAdvanced\\_4StreamsFilesAndDirectories\\_JavaAdvancedFilesAndStreamsLabResources\\03.CopyBytesOutput.txt");
        int currentByte = fileInputStream.read();
        while (currentByte >= 0) {
            if (currentByte == 32 || currentByte == 10) {
                fileOutputStream.write(currentByte);
            } else {
                String digit = String.valueOf(currentByte);
                for (int i = 0; i < digit.length(); i++) {
                    fileOutputStream.write(digit.charAt(i));
                }
            }
            currentByte = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
