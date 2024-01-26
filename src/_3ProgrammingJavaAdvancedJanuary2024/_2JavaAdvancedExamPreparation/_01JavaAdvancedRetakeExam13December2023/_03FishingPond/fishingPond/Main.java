package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._01JavaAdvancedRetakeExam13December2023._03FishingPond.fishingPond;

public class Main {
    public static void main(String[] args) {

        //Initialize the repository (Pond)
        Pond pond = new Pond(5);
//Initialize entities (Fish)
        Fish trout = new Fish("Trout", 5, "winter");
        Fish perch = new Fish("Perch", 2, "summer");
        Fish pike = new Fish("Pike", 4, "spring");
        Fish catfish = new Fish("Catfish", 8, "summer");

//Add Fish
        pond.addFish(trout);
        pond.addFish(perch);
        pond.addFish(pike);

//Remove Fish
        System.out.println(pond.removeFish("Trout"));  //true
        System.out.println(pond.removeFish("Carp"));  //false
        System.out.println(pike.getMatingSeason());  //spring

//Add Fish
        pond.addFish(catfish);

//Get the oldest fish
        System.out.println(pond.getOldestFish().getSpecies());  //Catfish

//Get pond vacancies
        System.out.println(pond.getVacancies()); //2
        System.out.println(pond.report());
//Fishes in the pond:
//This Perch is 2 years old and reproduces through summer.
//This Pike is 4 years old and reproduces through spring.
//This Catfish is 8 years old and reproduces through summer.

    }
}