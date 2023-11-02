package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        int sum = 0;
        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            int element;
            int elementToReplace;
            if (index < 0) {
                index = 0;
                element = distances.get(index);
                distances.remove(index);
                elementToReplace = distances.get(distances.size() - 1);
                distances.add(0, elementToReplace);
            } else if (index > distances.size() - 1) {
                index = distances.size() - 1;
                element = distances.get(index);
                distances.remove(index);
                elementToReplace = distances.get(0);
                distances.add(elementToReplace);
            } else {
                element = distances.get(index);
                distances.remove(index);
            }
            sum += element;
            for (int i = 0; i < distances.size(); i++) {
                if (distances.get(i) <= element) {
                    distances.set(i, distances.get(i) + element);
                } else {
                    distances.set(i, distances.get(i) - element);
                }
            }
        }
        System.out.printf("%d", sum);
    }
}
