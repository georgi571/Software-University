package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._02Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] articleDate = scanner.nextLine().split(", ");
        String title = articleDate[0];
        String content = articleDate[1];
        String author = articleDate[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            String[] commandsParts = scanner.nextLine().split(": ");
            String command = commandsParts[0];
            if (command.equals("Edit")) {
                String newContent = commandsParts[1];
                article.edit(newContent);
            } else if (command.equals("ChangeAuthor")) {
                String newAuthor = commandsParts[1];
                article.changeAuthor(newAuthor);
            } else if (command.equals("Rename")) {
                String newTitle = commandsParts[1];
                article.rename(newTitle);
            }
        }
        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
