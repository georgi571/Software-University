package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._7AssociativeArrays._2Exercise;

import java.util.*;

public class _08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map <String, List<String>> companyEmployees = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] input = command.split(" -> ");
            String companyName = input[0];
            String id = input[1];
            if (!companyEmployees.containsKey(companyName)) {
                companyEmployees.put(companyName, new ArrayList<>());
                companyEmployees.get(companyName).add(id);
            } else {
                List<String> currentID =  companyEmployees.get(companyName);
                if (!currentID.contains(id)) {
                    companyEmployees.get(companyName).add(id);
                }
            }
            command = scanner.nextLine();
        }
        companyEmployees.entrySet().forEach(entry -> {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().forEach(id -> System.out.printf("-- %s%n", id));
        });
    }
}
