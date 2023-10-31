package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._07AssociativeArrays._1Lab;

import java.util.*;

public class _02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, List<String>> synonyms = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            synonyms.putIfAbsent(word, new ArrayList<>());
            synonyms.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> kvp : synonyms.entrySet()) {
            System.out.printf("%s - %s%n", kvp.getKey(), String.join(", ", kvp.getValue()));
        }
    }
}
