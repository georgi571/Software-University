package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._2Exersices._08PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Pet> petMap = new HashMap<>();
        Map<String, Clinic> clinicMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            if (command.equals("Create")) {
                if (commandParts[1].equals("Pet")) {
                    String petName = commandParts[2];
                    int petAge = Integer.parseInt(commandParts[3]);
                    String petKind = commandParts[4];
                    Pet pet = new Pet(petName, petAge, petKind);
                    petMap.putIfAbsent(petName, pet);
                } else if (commandParts[1].equals("Clinic")) {
                    try {
                        String clinicName = commandParts[2];
                        int rooms = Integer.parseInt(commandParts[3]);
                        Clinic clinic = new Clinic(clinicName, rooms);
                        clinicMap.putIfAbsent(clinicName, clinic);
                    } catch (IllegalArgumentException exception) {
                        System.out.printf("%s%n", exception.getMessage());
                    }
                }
            } else if (command.equals("Add")) {
                String petName = commandParts[1];
                String clinicName = commandParts[2];
                Pet pet = petMap.get(petName);
                Clinic clinic = clinicMap.get(clinicName);
                System.out.printf("%s%n", clinic.addPet(pet));
            } else if (command.equals("Release")) {
                String clinicName = commandParts[1];
                Clinic clinic = clinicMap.get(clinicName);
                System.out.printf("%s%n", clinic.release());
            } else if (command.equals("HasEmptyRooms")) {
                String clinicName = commandParts[1];
                System.out.printf("%s%n", clinicMap.get(clinicName).hasEmptyRooms());
            } else if (command.equals("Print")) {
                String clinicName = commandParts[1];
                Clinic clinic = clinicMap.get(clinicName);
                if (commandParts.length == 2) {
                    for (Pet pet : clinic.getPets()) {
                        if (pet == null) {
                            System.out.printf("Room empty%n");
                        } else {
                            System.out.printf("%s%n", pet.toString());
                        }
                    }
                } else {
                    int room = Integer.parseInt(commandParts[2]);
                    clinic.printClinicRoomInfo(room);
                }
            }
        }
    }
}
