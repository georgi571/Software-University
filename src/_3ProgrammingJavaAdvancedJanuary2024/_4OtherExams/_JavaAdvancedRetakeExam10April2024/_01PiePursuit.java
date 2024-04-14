package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._JavaAdvancedRetakeExam10April2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01PiePursuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> contestants = new ArrayDeque<>();
        List<Integer> allContestants = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allContestants.size(); i++) {
            contestants.offer(allContestants.get(i));
        }
        Deque<Integer> pies = new ArrayDeque<>();
        List<Integer> allPies = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allPies.size(); i++) {
            pies.push(allPies.get(i));
        }
        while (!contestants.isEmpty() && !pies.isEmpty()) {
            int currentContestant = contestants.poll();
            int currentPie = pies.pop();
            if (currentContestant >= currentPie) {
                currentContestant -= currentPie;
                if (currentContestant > 0) {
                    contestants.offer(currentContestant);
                }
            } else {
                currentPie -= currentContestant;
                if (currentPie == 1) {
                    if (!pies.isEmpty()) {
                        int nextPie = pies.pop();
                        nextPie += currentPie;
                        pies.push(nextPie);
                    } else {
                        pies.push(currentPie);
                    }
                } else {
                    pies.push(currentPie);
                }
            }
        }
        if (pies.isEmpty() && !contestants.isEmpty()) {
            System.out.printf("We will have to wait for more pies to be baked!%n");
            System.out.printf("Contestants left:");
            while (!contestants.isEmpty()) {
                if (contestants.size() == 1) {
                    System.out.printf(" %d%n", contestants.poll());
                } else {
                    System.out.printf(" %d,", contestants.poll());
                }
            }
        } else if (!pies.isEmpty() && contestants.isEmpty()) {
            System.out.printf("Our contestants need to rest!%n");
            System.out.printf("Pies left:");
            List<Integer> piesList = new ArrayList<>();
            while (!pies.isEmpty()) {
                piesList.add(pies.pop());
            }
            for (int i = piesList.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    System.out.printf(" %d%n", piesList.get(i));
                } else {
                    System.out.printf(" %d,", piesList.get(i));
                }
            }
        } else if (pies.isEmpty() && contestants.isEmpty()) {
            System.out.printf("We have a champion!%n");
        }
    }
}
