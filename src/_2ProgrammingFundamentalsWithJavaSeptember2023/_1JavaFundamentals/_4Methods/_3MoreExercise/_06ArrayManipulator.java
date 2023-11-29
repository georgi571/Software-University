package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._4Methods._3MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _06ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandParts = command.split("\\s+");
            if (commandParts[0].equals("exchange")) {
                int index = Integer.parseInt(commandParts[1]);
                if (index > numbers.length - 1 || index < 0) {
                    System.out.printf("Invalid index%n");
                } else {
                    numbers = exchangeArray(numbers, index);
                }
            } else if (commandParts[0].equals("max")) {
                returnMaxIndex(numbers, commandParts[1]);
            } else if (commandParts[0].equals("min")) {
                returnMinIndex(numbers, commandParts[1]);
            } else if (commandParts[0].equals("first")) {
                int numberOfElements = Integer.parseInt(commandParts[1]);
                if (numberOfElements > numbers.length) {
                    System.out.printf("Invalid count%n");
                } else {
                    returnFirstElements(numbers, numberOfElements, commandParts[2]);
                }
            } else if (commandParts[0].equals("last")) {
                int numberOfElements = Integer.parseInt(commandParts[1]);
                if (numberOfElements > numbers.length) {
                    System.out.printf("Invalid count%n");
                } else {
                    returnLastElement(numbers, numberOfElements, commandParts[2]);
                }
            }
            command = scanner.nextLine();
        }
        System.out.printf("[");
        for (int i = 0; i < numbers.length - 1; i++) {
            System.out.printf("%d, ",numbers[i]);
        }
        System.out.printf("%d]", numbers[numbers.length - 1]);
    }
    private static int[] exchangeArray(int[] numbers, int i) {
        int[] numbers1 = new int[i + 1];
        int[] numbers2 = new int[numbers.length - i - 1];
        for (int j = 0; j <= i; j++) {
            numbers1[j] = numbers[j];
        }
        for (int j = i + 1; j < numbers.length ; j++) {
            numbers2[j -i - 1] = numbers[j];
        }
        for (int j = 0; j < numbers2.length; j++) {
            numbers[j] = numbers2[j];
        }
        for (int j = 0; j < numbers1.length; j++) {
            numbers[j + numbers2.length] = numbers1[j];
        }
        return numbers;
    }
    private static void returnMaxIndex(int[] numbers, String evenOrOdd) {
        int highestNumber = Integer.MIN_VALUE;
        int maxIndex = -1;
        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] >= highestNumber) {
                        highestNumber = numbers[i];
                        maxIndex = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 1) {
                    if (numbers[i] >= highestNumber) {
                        highestNumber = numbers[i];
                        maxIndex = i;
                    }
                }
            }
        }
        if (maxIndex != -1) {
            System.out.printf("%d%n", maxIndex);
        } else {
            System.out.printf("No matches%n");
        }
    }
    private static void returnMinIndex(int[] numbers, String evenOrOdd) {
        int lowestNumber = Integer.MAX_VALUE;
        int minIndex = -1;
        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] <= lowestNumber) {
                        lowestNumber = numbers[i];
                        minIndex = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 1) {
                    if (numbers[i] <= lowestNumber) {
                        lowestNumber = numbers[i];
                        minIndex = i;
                    }
                }
            }
        }
        if (minIndex != -1) {
            System.out.printf("%d%n", minIndex);
        } else {
            System.out.printf("No matches%n");
        }
    }
    private static void returnFirstElements(int[] numbers, int numberOfElements, String evenOrOdd) {
        int counter = 0;
        int[] pickedNumbers = new int[numbers.length];
        for (int i = 0; i < pickedNumbers.length; i++) {
            pickedNumbers[i] = -1;
        }
        System.out.printf("[");
        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    pickedNumbers[counter] = numbers[i];
                    counter++;
                    if (counter == numberOfElements) {
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 1) {
                    pickedNumbers[counter] = numbers[i];
                    counter++;
                    if (counter == numberOfElements) {
                        break;
                    }
                }
            }
        }
        int[] printNumbers = new int[counter];
        int counterLast = 0;
        for (int i = 0; i < pickedNumbers.length; i++) {
            if (pickedNumbers[i] > -1) {
                printNumbers[i] = pickedNumbers[i];
                counterLast++;
                if (counterLast == counter) {
                    break;
                }
            }
        }
        for (int i = 0; i < printNumbers.length - 1; i++) {
            System.out.printf("%d, ", printNumbers[i]);
        }
        if (printNumbers.length > 0) {
            System.out.printf("%d]%n", printNumbers[printNumbers.length - 1]);
        } else {
            System.out.printf("]%n");
        }
    }
    private static void returnLastElement(int[] numbers, int numberOfElements, String evenOrOdd) {
        int counter = 0;
        int[] pickedNumbers = new int[numbers.length];
        for (int i = 0; i < pickedNumbers.length; i++) {
            pickedNumbers[i] = -1;
        }
        System.out.printf("[");
        if (evenOrOdd.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    pickedNumbers[counter] = numbers[i];
                    counter++;
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 1) {
                    pickedNumbers[counter] = numbers[i];
                    counter++;
                }
            }
        }
        int num;
        if (counter <= numberOfElements) {
            num = counter;
        } else {
            num = numberOfElements;
        }
        int[] printNumbers = new int[num];
        int counterLast = 0;
        for (int i = pickedNumbers.length - 1; i >= 0; i--) {
            if (pickedNumbers[i] > -1) {
                printNumbers[counterLast] = pickedNumbers[i];
                counterLast++;
                if (counterLast == numberOfElements) {
                    break;
                }
            }
        }
        for (int i = printNumbers.length - 1; i > 0; i--) {
            System.out.printf("%d, ", printNumbers[i]);
        }
        if (printNumbers.length > 0) {
            System.out.printf("%d]%n", printNumbers[0]);
        } else {
            System.out.printf("]%n");
        }
    }
}
