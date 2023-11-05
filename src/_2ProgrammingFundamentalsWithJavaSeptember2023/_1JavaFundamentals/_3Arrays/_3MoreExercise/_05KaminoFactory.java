package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._3Arrays._3MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dnaLength = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int[] longestDNA = new int[dnaLength];
        int longestDNAList = 0;
        int startIndex = 0;
        int sumOfDNA = 0;
        int bestSamples = 0;
        int samples = 0;
        while (!command.equals("Clone them!")) {
            int[] dna = Arrays.stream(command.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            samples++;
            int currentLongest = 0;
            int currentLong = 1;
            int currentIndex = 0;
            int newIndex = 0;
            int sum = 0;
            for (int i = 0; i < dnaLength; i++) {
                if (dna[i] == 1) {
                    sum++;
                }
                if (i == dnaLength -1) {
                    if (currentLong > currentLongest) {
                        currentLongest = currentLong;
                        currentLong = 0;
                        currentIndex = newIndex;
                    }
                }
                for (int j = i + 1; j < i + 2 && j < dnaLength; j++) {
                    if (dna[i] == 1 && dna[j] == 1) {
                        currentLong++;
                    } else {
                        if (currentLong > currentLongest) {
                            currentLongest = currentLong;
                            currentLong = 1;
                            currentIndex = newIndex;
                        }
                    }
                    if (dna[i] == 0 && dna[j] == 1) {
                        newIndex = j;
                    }
                }
            }
            if (longestDNAList < currentLongest) {
                longestDNAList = currentLongest;
                startIndex = currentIndex;
                sumOfDNA = sum;
                for (int i = 0; i < dna.length; i++) {
                    longestDNA[i] = dna[i];
                    bestSamples = samples;
                }
            } else if (longestDNAList == currentLongest){
                if (startIndex > currentIndex) {
                    startIndex = currentIndex;
                    sumOfDNA = sum;
                    for (int i = 0; i < dna.length; i++) {
                        longestDNA[i] = dna[i];
                        bestSamples = samples;
                    }
                } else if (startIndex == currentIndex){
                    if (sumOfDNA < sum) {
                        sumOfDNA = sum;
                        for (int i = 0; i < dna.length; i++) {
                            longestDNA[i] = dna[i];
                            bestSamples = samples;
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSamples, sumOfDNA);
        for (int i = 0; i < longestDNA.length - 1; i++) {
            System.out.printf("%d ", longestDNA[i]);
        }
        System.out.printf("%d", longestDNA[longestDNA.length - 1]);
    }
}
