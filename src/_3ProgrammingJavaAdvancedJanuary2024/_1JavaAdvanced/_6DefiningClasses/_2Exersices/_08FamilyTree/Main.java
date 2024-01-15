package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._08FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Person person = new Person();
        if (input.contains(" ")) {
            person.setName(input);
        } else {
            person.setDateOfBirth(input);
        }
        List<String> listOfInput = getListOfInput(scanner, input, person);
        Map<String, String> pairNameDate = getMapOfPair(listOfInput);
        for (int i = 0; i < listOfInput.size(); i++) {
            String pair = listOfInput.get(i);
            String[] commandParts;
            if (pair.contains(" - ")) {
                commandParts = pair.split(" - ");
                String parentsInfo = commandParts[0];
                String childInfo = commandParts[1];
                if (person.getName().equals(childInfo) || person.getDateOfBirth().equals(childInfo)) {
                    pairNameDate.entrySet().forEach(entry -> {
                        Parents parents = new Parents();
                        if (entry.getKey().equals(parentsInfo)) {
                            parents.setName(entry.getKey());
                            parents.setBirthdayDate(entry.getValue());
                            person.addParents(parents);
                        } else if (entry.getValue().equals(parentsInfo)) {
                            parents.setName(entry.getKey());
                            parents.setBirthdayDate(entry.getValue());
                            person.addParents(parents);
                        }
                    });
                } else if (person.getName().equals(parentsInfo) || person.getDateOfBirth().equals(parentsInfo)) {
                    pairNameDate.entrySet().forEach(entry -> {
                        Childrens childrens = new Childrens();
                        if (entry.getKey().equals(childInfo)) {
                            childrens.setName(entry.getKey());
                            childrens.setDateOfBirth(entry.getValue());
                            person.addChildren(childrens);
                        } else if (entry.getValue().equals(childInfo)) {
                            childrens.setName(entry.getKey());
                            childrens.setDateOfBirth(entry.getValue());
                            person.addChildren(childrens);
                        }
                    });
                }
            }
        }
        person.printPersonInfo();
    }
        private static Map<String, String> getMapOfPair (List < String > listOfInput) {
            Map<String, String> pairMap = new LinkedHashMap<>();
            for (int i = 0; i < listOfInput.size(); i++) {
                if (!listOfInput.get(i).contains(" - ")) {
                    String[] commandParts = listOfInput.get(i).split("\\s+");
                    String name = commandParts[0] + " " + commandParts[1];
                    String birthday = commandParts[2];
                    pairMap.put(name, birthday);
                }
            }
            return pairMap;
        }

        private static List<String> getListOfInput (Scanner scanner, String input, Person person){
            List<String> listOfInput = new ArrayList<>();
            String command = scanner.nextLine();
            while (!command.equals("End")) {
                listOfInput.add(command);
                if (command.contains(input) && !command.contains(" - ")) {
                    String name = command.split("\\s+")[0];
                    String familyName = command.split("\\s+")[1];
                    String dateOfBirth = command.split("\\s+")[2];
                    if (person.getName() == null) {
                        person.setName(name + " " + familyName);
                    } else if (person.getDateOfBirth() == null) {
                        person.setDateOfBirth(dateOfBirth);
                    }
                }
                command = scanner.nextLine();
            }
            return listOfInput;
        }
    }
