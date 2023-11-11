package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._3MoreExercise._03CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        boolean hasNumber;
        for (int i = 1; i <= n; i++) {
            String[] engines = scanner.nextLine().split(" ");
            String engineModel = engines[0];
            int enginePower = Integer.parseInt(engines[1]);
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";
            if (engines.length == 4) {
                engineDisplacement = engines[2];
                engineEfficiency = engines[3];
            } else if (engines.length == 3) {
                String currentEngine = engines[2];
                hasNumber = checkForNumbers(currentEngine);
                if (hasNumber) {
                    engineDisplacement = engines[2];
                } else {
                    engineEfficiency = engines[2];
                }
            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= m; i++) {
            String[] cars = scanner.nextLine().split(" ");
            String carModel = cars[0];
            String carEngine = cars[1];
            String carWeight = "n/a";
            String carColor = "n/a";
            if (cars.length == 4) {
                carWeight = cars[2];
                carColor = cars[3];
            } else if (cars.length == 3) {
                String currentWeight = cars[2];
                hasNumber = checkForNumbers(currentWeight);
                if (hasNumber) {
                    carWeight = cars[2];
                } else {
                    carColor = cars[2];
                }
            }
            for (int j = 0; j < engineList.size(); j++) {
                if (engineList.get(j).getModel().equals(carEngine)) {
                    Car car = new Car(carModel, engineList.get(j), carWeight, carColor);
                    carList.add(car);
                    break;
                }
            }
        }
        for (int i = 0; i < carList.size(); i++) {
            System.out.printf("%s:%n",carList.get(i).getModel());
            System.out.printf("  %s:%n",carList.get(i).getEngine().getModel());
            System.out.printf("    Power: %d%n",carList.get(i).getEngine().getPower());
            System.out.printf("    Displacement: %s%n",carList.get(i).getEngine().getDisplacement());
            System.out.printf("    Efficiency: %s%n",carList.get(i).getEngine().getEfficiency());
            System.out.printf("  Weight: %s%n",carList.get(i).getWeight());
            System.out.printf("  Color: %s%n",carList.get(i).getColor());
        }
    }
    private static boolean checkForNumbers (String current) {
        for (int i = 0; i < current.length(); i++) {
            int currentNumber = current.charAt(i);
            if (currentNumber > 47 && currentNumber < 58) {
                return true;
            }
        }
        return false;
    }
}
