package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._1Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputWords = Arrays.stream(scanner.nextLine()
                                .split(" "))
                        .collect(Collectors.toList());
        Random random = new Random();
        int size = inputWords.size();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(inputWords.size());
            System.out.println(inputWords.get(index));
            inputWords.remove(inputWords.get(index));
        }
    }
}