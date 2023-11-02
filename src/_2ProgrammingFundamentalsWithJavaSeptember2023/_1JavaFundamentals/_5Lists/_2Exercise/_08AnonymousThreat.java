package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> text = Arrays.stream(scanner.nextLine()
                                .split("\\s+"))
                        .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] input = command.split(" ");
            if (input[0].equals("merge")) {
                int startIndex = Integer.parseInt(input[1]);
                if (startIndex < 0) {
                    startIndex = 0;
                } else if (startIndex > text.size() - 1) {
                    startIndex = text.size() - 1;
                }
                int endIndex = Integer.parseInt(input[2]);
                if (endIndex < 0) {
                    endIndex = 0;
                } else if (endIndex > text.size() - 1) {
                    endIndex = text.size() - 1;
                }
                if (startIndex >= 0 && startIndex <= text.size() - 1 && endIndex >= 0 && endIndex <= text.size() - 1) {
                    for (int i = startIndex; i < endIndex; i++) {
                        text.set(i, text.get(i) + text.get(i + 1));
                        text.remove(i + 1);
                        i = startIndex - 1;
                        endIndex -= 1;
                    }
                }
            } else if (input[0].equals("divide")) {
                int index = Integer.parseInt(input[1]);
                int partitions = Integer.parseInt(input[2]);
                String textForDivide = text.get(index);
                text.remove(index);
                if (partitions > 0) {
                    int getLength = textForDivide.length();
                    int lengthPerItem = getLength / partitions;
                    int lengthLastItem = getLength - (lengthPerItem * (partitions - 1));
                    int lengthForChar = 0;
                    int indexForAdd = index;
                    for (int i = 1; i <= partitions; i++) {
                        String item = "";
                        if (i <= partitions - 1) {
                            for (int j = 0; j < lengthPerItem; j++) {
                                char currentSymbol = textForDivide.charAt(lengthForChar);
                                item += currentSymbol;
                                lengthForChar += 1;
                            }
                        } else {
                            for (int j = 0; j < lengthLastItem; j++) {
                                char currentSymbol = textForDivide.charAt(lengthForChar);
                                item += currentSymbol;
                                lengthForChar += 1;
                            }
                        }
                        text.add(indexForAdd, item);
                        indexForAdd += 1;
                        item = "";
                    }
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < text.size() - 1 ; i++) {
            System.out.printf("%s ", text.get(i));
        }
            System.out.printf("%s", text.get(text.size() - 1));
    }
}
