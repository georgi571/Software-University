package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._5Lists._2Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> partyList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String name = command[0];
            String willGoOrNot = command[2];
            if (willGoOrNot.equals("going!")) {
                if (!partyList.contains(name)) {
                    partyList.add(name);
                } else {
                    System.out.printf("%s is already in the list!%n", name);
                }
            } else if (willGoOrNot.equals("not")) {
                if (partyList.contains(name)) {
                    int index = partyList.indexOf(name);
                    partyList.remove(index);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String guest : partyList) {
            System.out.printf("%s%n", guest);
        }
    }
}
