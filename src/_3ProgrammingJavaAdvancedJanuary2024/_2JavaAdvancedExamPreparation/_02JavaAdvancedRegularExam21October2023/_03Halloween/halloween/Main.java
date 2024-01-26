package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._02JavaAdvancedRegularExam21October2023._03Halloween.halloween;

public class Main {
    public static void main(String[] args) {

        // Initialize the repository
        House house = new House(6);

// Initialize entity
        Kid firstKid = new Kid("Yoana", 10, "Osogovska");
// Print Кid
        System.out.println(firstKid); // Yoana, 10 years old, from Osogovska

// Add First Кid
        house.addKid(firstKid);

// Remove Kid
        System.out.println(house.removeKid("Sara")); //false
        System.out.println(house.removeKid("Yoana")); //true

        Kid secondKid = new Kid("Lily", 5, "Pirina");
        Kid thirdKid = new Kid("Anna", 7, "Pirotska");
        Kid fourthKid = new Kid("Selin", 8, "Solunska");

        house.addKid(secondKid);
        house.addKid(thirdKid);
        house.addKid(fourthKid);

        Kid kid = house.getKid("Pirotska");

        System.out.println(kid); // Anna, 7 years old, from Pirotska

// All kids in  house
        System.out.println(house.getAllKids()); // 3

// Information Statistics
        System.out.println(house.getStatistics());

//Children who visited a house for candy:
//Lily from Pirina street
// Anna from Pirotska street
// Selin from Solunska stret

    }
}
