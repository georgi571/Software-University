package _2ProgrammingFundamentalsWithJavaSeptember2023._2FundamentalsExamsPreparation._4ProgrammingFundamentalsFinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<Integer, Integer>> hero = new LinkedHashMap();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String heroName = input[0];
            int HP = Integer.parseInt(input[1]);
            int MP = Integer.parseInt(input[2]);
            Map<Integer, Integer> heroStats = new LinkedHashMap<>();
            heroStats.put(HP, MP);
            hero.put(heroName, heroStats);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandParts = command.split("\\s*-\\s*");
            String currentCommand = commandParts[0];
            String heroName = commandParts[1];
            if (currentCommand.equals("CastSpell")) {
                int neededMP = Integer.parseInt(commandParts[2]);
                String spellName = commandParts[3];
                hero.entrySet().forEach(entry-> {
                    if (entry.getKey().equals(heroName)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getHP = entry2.getKey();
                            int getMP = entry2.getValue();
                            int newMP = getMP - neededMP;
                            if (getMP >= neededMP) {
                                Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                                oldInfo.put(getHP, getMP);
                                Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                                newInfo.put(getHP, newMP);
                                hero.replace(heroName, oldInfo, newInfo);
                                System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, newMP);
                            } else {
                                System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                            }
                        });
                    }
                });
            } else if (currentCommand.equals("TakeDamage")) {
                int damage = Integer.parseInt(commandParts[2]);
                String attacker = commandParts[3];
                AtomicInteger newHP = new AtomicInteger();
                hero.entrySet().forEach(entry-> {
                    if (entry.getKey().equals(heroName)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getHP = entry2.getKey();
                            int getMP = entry2.getValue();
                            newHP.set(getHP - damage);
                            if (getHP > damage) {
                                Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                                oldInfo.put(getHP, getMP);
                                Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                                newInfo.put(newHP.get(), getMP);
                                hero.replace(heroName, oldInfo, newInfo);
                                System.out.printf("%s was hit for %d HP by %s and now has %s HP left!%n", heroName, damage, attacker, newHP);
                            }
                        });
                    }
                });
                if (newHP.get() <= 0) {
                    hero.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }
            } else if (currentCommand.equals("Recharge")) {
                int amountOfMP = Integer.parseInt(commandParts[2]);
                hero.entrySet().forEach(entry-> {
                    if (entry.getKey().equals(heroName)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getHP = entry2.getKey();
                            int getMP = entry2.getValue();
                            int newMP = getMP + amountOfMP;
                            if (newMP > 200) {
                                newMP = 200;
                            }
                            int increaseMP = newMP - getMP;
                            Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                            oldInfo.put(getHP, getMP);
                            Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                            newInfo.put(getHP, newMP);
                            hero.replace(heroName, oldInfo, newInfo);
                            System.out.printf("%s recharged for %d MP!%n", heroName, increaseMP);
                        });
                    }
                });
            } else if (currentCommand.equals("Heal")) {
                int amountOfHP = Integer.parseInt(commandParts[2]);
                hero.entrySet().forEach(entry-> {
                    if (entry.getKey().equals(heroName)) {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            int getHP = entry2.getKey();
                            int getMP = entry2.getValue();
                            int newHP = getHP + amountOfHP;
                            if (newHP > 100) {
                                newHP = 100;
                            }
                            int increaseHP = newHP - getHP;
                            Map<Integer, Integer> oldInfo = new LinkedHashMap<>();
                            oldInfo.put(getHP, getMP);
                            Map<Integer, Integer> newInfo = new LinkedHashMap<>();
                            newInfo.put(newHP, getMP);
                            hero.replace(heroName, oldInfo, newInfo);
                            System.out.printf("%s healed for %d HP!%n", heroName, increaseHP);
                        });
                    }
                });
            }
            command = scanner.nextLine();
        }
        hero.entrySet().forEach(entry-> {
            entry.getValue().entrySet().forEach(entry2 -> {
                System.out.printf("%s%n",entry.getKey());
                System.out.printf("  HP: %d%n",entry2.getKey());
                System.out.printf("  MP: %d%n", entry2.getValue());
            });
        });
    }
}
