package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._2Exercise;

import java.util.Scanner;

public class _03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] path = scanner.nextLine().split("\\\\");
        String[] fileInfo = path[path.length - 1].split("\\.");
        String fileName = fileInfo[0];
        String fileExtension = fileInfo[1];
        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s%n", fileExtension);
    }
}
