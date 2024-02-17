package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._10BasicAlgorithms._1Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        array = mergeSort(array);
        for (int current : array) {
            System.out.printf("%d ", current);
        }
    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int halfIndex = array.length/2;
        int firstArrayLength = halfIndex;
        int secondArrayLength = array.length - halfIndex;
        int[] firstPartition = new int[firstArrayLength];
        int[] secondPartition = new int[secondArrayLength];
        for (int i = 0; i < firstArrayLength; i++) {
            firstPartition[i] = array[i];
        }
        for (int i = firstArrayLength; i < secondArrayLength + firstArrayLength; i++) {
            secondPartition[i - firstArrayLength] = array[i];
        }
        firstPartition = mergeSort(firstPartition);
        secondPartition = mergeSort(secondPartition);
        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;
        while (firstPartitionIndex < firstArrayLength && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];
                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];
                mainIndex++;
                secondPartitionIndex++;
            }
        }
        while (firstPartitionIndex < firstArrayLength) {
            array[mainIndex] = firstPartition[firstPartitionIndex];
            mainIndex++;
            firstPartitionIndex++;
        }
        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];
            mainIndex++;
            secondPartitionIndex++;
        }
        return array;
    }
}
