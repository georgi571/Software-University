package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._02JavaAdvancedRegularExam22June2024;

import java.util.*;
import java.util.stream.Collectors;

public class _01RapidCourier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> packagesWeight = new ArrayDeque<>();
        List<Integer> allPackagesWeight = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allPackagesWeight.size(); i++) {
            packagesWeight.push(allPackagesWeight.get(i));
        }
        Deque<Integer> couriersCapacities = new ArrayDeque<>();
        List<Integer> allCouriersCapacities = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < allCouriersCapacities.size(); i++) {
            couriersCapacities.offer(allCouriersCapacities.get(i));
        }
        int totalWeight = 0;
        while (!packagesWeight.isEmpty() && !couriersCapacities.isEmpty()) {
            int currentCourier = couriersCapacities.poll();
            int currentPackage = packagesWeight.pop();
            if (currentCourier >= currentPackage) {
                currentCourier -= 2 * currentPackage;
                totalWeight += currentPackage;
                if (currentCourier > 0) {
                    couriersCapacities.offer(currentCourier);
                }
            } else {
                currentPackage -= currentCourier;
                totalWeight += currentCourier;
                packagesWeight.push(currentPackage);
            }
        }
        System.out.printf("Total weight: %d kg%n", totalWeight);
        if (couriersCapacities.isEmpty() && packagesWeight.isEmpty()) {
            System.out.printf("Congratulations, all packages were delivered successfully by the couriers today.%n");
        } else if (couriersCapacities.isEmpty() && !packagesWeight.isEmpty()) {
            System.out.printf("Unfortunately, there are no more available couriers to deliver the following packages:");
            List<Integer> leftPackages = new ArrayList<>();
            while (!packagesWeight.isEmpty()) {
                leftPackages.add(packagesWeight.pop());
            }
            for (int i = leftPackages.size() - 1; i >= 0; i--) {
                System.out.printf(" %d", leftPackages.get(i));
                if (i > 0) {
                    System.out.printf(",");
                }
            }
            System.out.printf("%n");
        } else if (!couriersCapacities.isEmpty() && packagesWeight.isEmpty()) {
            System.out.printf("Couriers are still on duty:");
            while (!couriersCapacities.isEmpty()) {
                System.out.printf(" %d", couriersCapacities.poll());
                if (!couriersCapacities.isEmpty()) {
                    System.out.printf(",");
                }
            }
            System.out.printf(" but there are no more packages to deliver.%n");
        }
    }
}
