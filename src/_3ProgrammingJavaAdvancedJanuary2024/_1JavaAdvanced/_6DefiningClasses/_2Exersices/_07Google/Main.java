package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Person> personMap = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s+");
            String name = commandParts[0];
            Person person;
            if (personMap.containsKey(name)) {
                person = personMap.get(name);
            } else {
                person = new Person(name);
            }
            String informationAbout = commandParts[1];
            if (informationAbout.equals("company")) {
                String companyName = commandParts[2];
                String department = commandParts[3];
                double salary = Double.parseDouble(commandParts[4]);
                Company company = new Company(companyName, department, salary);
                person.setCompany(company);
            } else if (informationAbout.equals("pokemon")) {
                String pokemonName = commandParts[2];
                String pokemonType = commandParts[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                person.addPokemon(pokemon);
            } else if (informationAbout.equals("parents")) {
                String parentName = commandParts[2];
                String parentBirthday = commandParts[3];
                Parents parents = new Parents(parentName, parentBirthday);
                person.addParent(parents);
            } else if (informationAbout.equals("children")) {
                String childName = commandParts[2];
                String childBirthday = commandParts[3];
                Children children = new Children(childName, childBirthday);
                person.addChildren(children);
            } else if (informationAbout.equals("car")) {
                String carModel = commandParts[2];
                int carSpeed = Integer.parseInt(commandParts[3]);
                Car car = new Car(carModel, carSpeed);
                person.setCar(car);
            }
            personMap.putIfAbsent(name, person);
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        personMap.get(command).printPersonInfo(personMap.get(command));
    }
}
