package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._3MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class _04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstRowNumbers = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> secondRowNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        if (firstRowNumbers.size() > secondRowNumbers.size()) {
            firstRowBigger(firstRowNumbers, secondRowNumbers);
        } else {
            secondRowBigger(firstRowNumbers, secondRowNumbers);
        }
    }
    private static void firstRowBigger (List<Integer> firstRowNumbers, List<Integer> secondRowNumbers) {
        List<Integer> mergedRow = new ArrayList<>();
        int indexOfFirst = 0;
        int indexOfSecond = secondRowNumbers.size() - 1;
        for (int i = 0; i < secondRowNumbers.size(); i++) {
            mergedRow.add(firstRowNumbers.get(indexOfFirst));
            indexOfFirst++;
            mergedRow.add(secondRowNumbers.get(indexOfSecond));
            indexOfSecond--;
        }
        int firstNumber = firstRowNumbers.get(firstRowNumbers.size() - 1);
        int secondNumber = firstRowNumbers.get(firstRowNumbers.size() - 2);
        if (firstNumber > secondNumber) {
            for (int i = 0; i < mergedRow.size(); i++) {
                if (mergedRow.get(i) >= firstNumber || mergedRow.get(i) <= secondNumber) {
                    mergedRow.remove(i);
                    i-= 1;
                }
            }
        } else {
            for (int i = 0; i < mergedRow.size(); i++) {
                if (mergedRow.get(i) <= firstNumber || mergedRow.get(i) >= secondNumber) {
                    mergedRow.remove(i);
                    i-= 1;
                }
            }
        }
        Collections.sort(mergedRow);
        for (int i = 0; i < mergedRow.size() - 1; i++) {
            System.out.printf("%d ", mergedRow.get(i));
        }
        System.out.printf("%d", mergedRow.get(mergedRow.size() - 1));
    }
    private static void secondRowBigger (List<Integer> firstRowNumbers, List<Integer> secondRowNumbers) {
        List<Integer> mergedRow = new ArrayList<>();
        int indexOfFirst = 0;
        int indexOfSecond = secondRowNumbers.size() - 1;
        for (int i = 0; i < firstRowNumbers.size(); i++) {
            mergedRow.add(firstRowNumbers.get(indexOfFirst));
            indexOfFirst++;
            mergedRow.add(secondRowNumbers.get(indexOfSecond));
            indexOfSecond--;
        }
        int firstNumber = secondRowNumbers.get(0);
        int secondNumber = secondRowNumbers.get(1);
        if (firstNumber > secondNumber) {
            for (int i = 0; i < mergedRow.size(); i++) {
                if (mergedRow.get(i) >= firstNumber || mergedRow.get(i) <= secondNumber) {
                    mergedRow.remove(i);
                    i-= 1;
                }
            }
        } else {
            for (int i = 0; i < mergedRow.size(); i++) {
                if (mergedRow.get(i) <= firstNumber || mergedRow.get(i) >= secondNumber) {
                    mergedRow.remove(i);
                    i-= 1;
                }
            }
        }
        Collections.sort(mergedRow);
        for (int i = 0; i < mergedRow.size() - 1; i++) {
            System.out.printf("%d ", mergedRow.get(i));
        }
        System.out.printf("%d", mergedRow.get(mergedRow.size() - 1));
    }
}
