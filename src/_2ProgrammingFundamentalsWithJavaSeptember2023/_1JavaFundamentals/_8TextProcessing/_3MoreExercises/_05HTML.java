package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._8TextProcessing._3MoreExercises;

import java.util.Scanner;

public class _05HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.printf("<h1>%n");
        System.out.printf("%s%n",title);
        System.out.printf("</h1>%n");
        String article = scanner.nextLine();
        System.out.printf("<article>%n");
        System.out.printf("%s%n",article);
        System.out.printf("</article>%n");
        String command = scanner.nextLine();
        while (!command.equals("end of comments")) {
            String comment = command;
            System.out.printf("<div>%n");
            System.out.printf("%s%n",comment);
            System.out.printf("</div>%n");
            command = scanner.nextLine();
        }
    }
}
