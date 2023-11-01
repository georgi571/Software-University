package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrayList = Arrays.stream(scanner.nextLine()
                                .split("\\|"))
                        .collect(Collectors.toList());
        Collections.reverse(arrayList);
        System.out.printf(arrayList.toString()
                .replace("[","")
                .replace("]", "")
                .trim()
                .replaceAll(",", "")
                .replaceAll("\\s+"," "));
    }
}
