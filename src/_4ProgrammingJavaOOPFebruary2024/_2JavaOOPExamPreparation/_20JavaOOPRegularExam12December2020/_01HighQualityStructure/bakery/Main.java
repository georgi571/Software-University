package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.bakedFoods.interfaces.BakedFood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.drinks.interfaces.Drink;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.entities.tables.interfaces.Table;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces.DrinkRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces.FoodRepository;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._20JavaOOPRegularExam12December2020._01HighQualityStructure.bakery.repositories.interfaces.TableRepository;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository; // TODO:  new FoodRepositoryImpl<>();
        DrinkRepository<Drink> drinkRepository;  // TODO:  new DrinkRepositoryImpl<>();
        TableRepository<Table> tableRepository; // TODO:  new TableRepositoryImpl<>();

        Controller controller; // TODO: new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        // TODO:OPTIONAL
//        ConsoleReader reader = new ConsoleReader();
//        ConsoleWriter writer = new ConsoleWriter();
//        EngineImpl engine = new EngineImpl(reader, writer, controller);
//        engine.run();
    }
}
