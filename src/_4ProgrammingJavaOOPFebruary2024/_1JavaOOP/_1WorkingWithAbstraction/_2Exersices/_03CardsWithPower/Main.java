package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._2Exersices._03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();
        Card card = new Card(CardSuit.valueOf(suit), CardRank.valueOf(rank));
        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRank(), card.getCardSuit(), card.getPower());
    }
}
