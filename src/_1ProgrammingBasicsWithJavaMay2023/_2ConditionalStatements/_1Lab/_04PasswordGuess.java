package _1ProgrammingBasicsWithJavaMay2023._2ConditionalStatements._1Lab;

import java.util.Scanner;

public class _04PasswordGuess {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String passInput = scanner.nextLine();
        if (passInput.equals("s3cr3t!P@ssw0rd")){
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
