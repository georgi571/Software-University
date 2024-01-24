package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._24JavaAdvancedRegularExam26Oct2019;

import java.util.*;
import java.util.stream.Collectors;

public class _01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> male = new ArrayDeque<>();
        List<Integer> allMale = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allMale.size(); i++) {
            male.push(allMale.get(i));
        }
        Deque<Integer> female = new ArrayDeque<>();
        List<Integer> allFemale = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allFemale.size(); i++) {
            female.offer(allFemale.get(i));
        }
        int matches = 0;
        while (!female.isEmpty() && !male.isEmpty()) {
            if (male.peek() <= 0) {
                male.pop();
            } else if (female.peek() <= 0) {
                female.poll();
            } else {
                if (female.peek() % 25 == 0) {
                    female.poll();
                    if (!female.isEmpty()) {
                        female.poll();
                    }
                } else if (male.peek() % 25 == 0) {
                    male.pop();
                    if (!male.isEmpty()) {
                        male.pop();
                    }
                } else {
                    int currentFemale = female.poll();
                    int currentMale = male.pop();
                    if (currentMale == currentFemale) {
                        matches++;
                    } else {
                        currentMale -= 2;
                        male.push(currentMale);
                    }
                }
            }
        }
        System.out.printf("Matches: %d%n", matches);
        if (male.isEmpty()) {
            System.out.printf("Males left: none");
        } else {
            System.out.printf("Males left: ");
            while (!male.isEmpty()) {
                System.out.printf("%d", male.pop());
                if (!male.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
        if (female.isEmpty()) {
            System.out.printf("Females left: none");
        } else {
            System.out.printf("Females left: ");
            while (!female.isEmpty()) {
                System.out.printf("%d", female.poll());
                if (!female.isEmpty()) {
                    System.out.printf(", ");
                }
            }
        }
        System.out.printf("%n");
    }
}
