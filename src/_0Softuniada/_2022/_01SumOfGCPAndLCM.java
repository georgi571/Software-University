package _0Softuniada._2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01SumOfGCPAndLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int nod = 0;
        int nok = 0;
        List<Integer> nodN = new ArrayList<>();
        List<Integer> nodM = new ArrayList<>();
        List<Integer> nokN = new ArrayList<>();
        List<Integer> nokM = new ArrayList<>();
        nokN.add(n);
        nokM.add(m);
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nodN.add(i);
            }
        }
        for (int i = 1; i <= m; i++) {
            if (m % i == 0) {
                nodM.add(i);
            }
        }
        for (Integer currentN : nodN) {
            for (Integer currentM : nodM) {
                if (currentN == currentM) {
                    nod = currentN;
                }
            }
        }
        while (nok == 0) {
            nokN.add(nokN.get(nokN.size() - 1) + n);
            nokM.add(nokM.get(nokM.size() - 1) + m);
            if (n < m) {
                if (nokM.contains(nokN.get(nokN.size() - 1))) {
                    nok = nokN.get(nokN.size() - 1);
                    break;
                }
            } else {
                if (nokN.contains(nokM.get(nokM.size() - 1))) {
                    nok = nokM.get(nokM.size() - 1);
                    break;
                }
            }
        }
        int sum = nok + nod;
        System.out.printf("%d", sum);
    }
}
