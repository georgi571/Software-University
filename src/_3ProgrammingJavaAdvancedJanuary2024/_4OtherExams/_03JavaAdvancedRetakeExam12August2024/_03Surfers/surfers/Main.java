package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._03JavaAdvancedRetakeExam12August2024._03Surfers.surfers;

public class Main {
    public static void main(String[] args) {
//Initialize the repositories (Beach)
        Beach malibu = new Beach("Malibu", 3);
        Beach playaLaRopa = new Beach("Playa La Ropa", 2);
        Beach veleka = new Beach("Veleka", 0);
//Initialize entities (Surfer)
        Surfer john = new Surfer("John", 40, 10, true, 100);
        Surfer mike = new Surfer("Mike", 20, 1, false, 59);
        Surfer charlie = new Surfer("Charlie", 55, 19, true, 50);
        Surfer hulk = new Surfer("Hulk", 18, 0, false, 49);
        Surfer asen = new Surfer("Asen", 28, 10, false, 500);

        System.out.println(malibu.addSurfer(mike));
        System.out.println(malibu.addSurfer(john));
        System.out.println(malibu.getSurfersWithPersonalSurfboards());

        System.out.println(veleka.addSurfer(charlie));

        System.out.println(veleka.addSurfer(asen));

        System.out.println(playaLaRopa.addSurfer(hulk));

        System.out.println(veleka.getMostExperiencedSurfer());

        System.out.println(malibu.getReport());
        System.out.println(playaLaRopa.getReport());
        System.out.println(veleka.getReport());


        ////Surfer Mike added.
        ////Surfer John added.
        ////Surfers who have their own surfboards: John
        ////Surfer Charlie added.
        ////There are no free surfboards.
        ////Hulk has not enough money to rent a surfboard.
        ////Charlie is most experienced surfer with 19 years experience.
        ////Beach Malibu was visited by the following surfers:
        ////1. Mike with 1 years experience.
        ////2. John with 10 years experience.
        ////There are no surfers on Playa La Ropa beach.
        ////Beach Veleka was visited by the following surfers:
        ////1. Charlie with 19 years experience.
    }
}