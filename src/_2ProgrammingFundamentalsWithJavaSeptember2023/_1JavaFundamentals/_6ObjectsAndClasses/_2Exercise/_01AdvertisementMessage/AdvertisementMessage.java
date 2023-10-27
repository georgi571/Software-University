package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._01AdvertisementMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> phrase = new ArrayList<>();
        phrase.add("Excellent product.");
        phrase.add("Such a great product.");
        phrase.add("I always use that product.");
        phrase.add("Best product of its category.");
        phrase.add("Exceptional product.");
        phrase.add("I can’t live without this product.");
        List<String> event = new ArrayList<>();
        event.add("Now I feel good.");
        event.add("I have succeeded with this product.");
        event.add("Makes miracles. I am happy of the results!");
        event.add("I cannot believe but now I feel awesome.");
        event.add("Try it yourself, I am very satisfied.");
        event.add("I feel great!");
        List<String> author = new ArrayList<>();
        author.add("Diana");
        author.add("Petya");
        author.add("Stella");
        author.add("Elena");
        author.add("Katya");
        author.add("Iva");
        author.add("Annie");
        author.add("Eva");
        List<String> city = new ArrayList<>();
        city.add("Burgas");
        city.add("Sofia");
        city.add("Plovdiv");
        city.add("Varna");
        city.add("Ruse");
        Random random = new Random();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int indexPhrase = random.nextInt(phrase.size() - 1);
            int indexEvent = random.nextInt(phrase.size() - 1);
            int indexAuthor = random.nextInt(phrase.size() - 1);
            int indexCity = random.nextInt(phrase.size() - 1);
            System.out.printf("%s %s %S – %s%n", phrase.get(indexPhrase), event.get(indexEvent), author.get(indexAuthor), city.get(indexCity));
        }
    }
}
