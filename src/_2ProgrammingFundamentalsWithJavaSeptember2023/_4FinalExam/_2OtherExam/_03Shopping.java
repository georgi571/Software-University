package _2ProgrammingFundamentalsWithJavaSeptember2023._4FinalExam._2OtherExam;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class _03Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Map<String, Map<String, List<String>>> shops = new LinkedHashMap<>();
        while (!command.equals("Go Shopping")) {
            String[] commandParts = command.split("->");
            String storeName = commandParts[1];
            if (commandParts[0].equals("Add")) {
                List<String> items = Arrays.stream(commandParts[2]
                                        .split(","))
                                .collect(Collectors.toList());
                if (shops.containsKey(storeName)) {
                    for (int i = 0; i < items.size(); i++) {
                        AtomicBoolean isItemExist = new AtomicBoolean(false);
                        String currentItem = items.get(i);
                        shops.entrySet().forEach(entry -> {
                            entry.getValue().entrySet().forEach(entry2 -> {
                                if (entry2.getValue().contains(currentItem)) {
                                    isItemExist.set(true);
                                }
                            });
                        });
                        if (!isItemExist.get()) {
                            shops.get(storeName).get("normal").add(currentItem);
                        }
                    }
                } else {
                    if (shops.isEmpty()) {
                        Map<String, List<String>> normal = new LinkedHashMap<>();
                        Map<String, List<String>> special = new LinkedHashMap<>();
                        List<String> itemList = new ArrayList<>();
                        normal.put("normal" , items);
                        shops.put(storeName, normal);
                        shops.get(storeName).put("special" , itemList);
                    } else {
                        Map<String, List<String>> normal = new LinkedHashMap<>();
                        Map<String, List<String>> special = new LinkedHashMap<>();
                        List<String> itemList = new ArrayList<>();
                        for (int i = 0; i < items.size(); i++) {
                            AtomicBoolean isItemExist = new AtomicBoolean(false);
                            String currentItem = items.get(i);
                            shops.entrySet().forEach(entry -> {
                                entry.getValue().entrySet().forEach(entry2 -> {
                                    if (entry2.getValue().contains(currentItem)) {
                                        isItemExist.set(true);
                                    }
                                });
                            });
                            if (!isItemExist.get()) {
                                itemList.add(currentItem);
                            }
                        }
                        normal.put("normal" , itemList);
                        shops.put(storeName, normal);
                        List<String> newItemList = new ArrayList<>();
                        shops.get(storeName).put("special" , newItemList);
                    }
                }
            } else if (commandParts[0].equals("Important")) {
                if (shops.containsKey(storeName)) {
                    String currentItem = commandParts[2];
                    AtomicBoolean isItemExist = new AtomicBoolean(false);
                    shops.entrySet().forEach(entry -> {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            if (entry2.getValue().contains(currentItem)) {
                                isItemExist.set(true);
                            }
                        });
                    });
                    if (!isItemExist.get()) {
                        shops.get(storeName).get("normal").add(0, currentItem);
                        shops.get(storeName).get("special").add(currentItem);
                    }
                } else {
                    Map<String, List<String>> normal = new LinkedHashMap<>();
                    Map<String, List<String>> special = new LinkedHashMap<>();
                    List<String> itemList = new ArrayList<>();
                    String currentItem = commandParts[2];
                    AtomicBoolean isItemExist = new AtomicBoolean(false);
                    shops.entrySet().forEach(entry -> {
                        entry.getValue().entrySet().forEach(entry2 -> {
                            if (entry2.getValue().contains(currentItem)) {
                                isItemExist.set(true);
                            }
                        });
                    });
                    if (!isItemExist.get()) {
                        itemList.add(currentItem);
                    }
                    normal.put("normal" , itemList);
                    shops.put(storeName, normal);
                    shops.get(storeName).put("special" , itemList);
                }
            } else if (commandParts[0].equals("Remove")) {
                if (shops.containsKey(storeName)) {
                    if (shops.get(storeName).get("special").isEmpty()) {
                        shops.remove(storeName);
                    }
                }
            }
            command = scanner.nextLine();
        }
        shops.entrySet().forEach(entry -> {
            System.out.printf("%s:%n", entry.getKey());
            entry.getValue().entrySet().forEach(entry2 -> {
                if (entry2.getKey().equals("normal")) {
                    for (int i = 0; i < entry2.getValue().size(); i++) {
                        System.out.printf(" - %s%n", entry2.getValue().get(i));
                    }
                }
            });
        });
    }
}
