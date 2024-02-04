package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._1WorkingWithAbstraction._2Exersices._06GreedyTimes;

import java.util.HashMap;
import java.util.Map;

public class Bag {
    private long capacity;
    private long currentCapacity;
    private long gold;
    public Map<String, Long> gem;
    public Map<String, Long> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.gem = new HashMap<>();
        this.cash = new HashMap<>();
        this.gold = -1;
    }

    public void addGold(long amount) {
        if (hasFreeCapacity(amount)) {
            if (this.gold == -1) {
                this.gold = 0;
            }
            this.gold += amount;
            this.currentCapacity += amount;
        }
    }

    public void addGem(String name, long amount) {
        long totalGems = getTotalGems();
        if (hasFreeCapacity(amount) && totalGems + amount <= this.gold) {
            if (this.gem.containsKey(name)) {
                this.gem.put(name, this.gem.get(name) + amount);
            } else {
                this.gem.put(name, amount);
            }
            this.currentCapacity += amount;
        }
    }

    public void addCash(String name, long amount) {
        long totalCash = getTotalCash();
        long totalGems = getTotalGems();
        if (hasFreeCapacity(amount) && totalCash + amount <= totalGems) {
            if (this.cash.containsKey(name)) {
                this.cash.put(name, this.cash.get(name) + amount);
            } else {
                this.cash.put(name, amount);
            }
            this.currentCapacity += amount;
        }
    }

    public void printContent() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.gold >= 0) {
            stringBuilder.append(String.format("<Gold> $%d", this.gold)).append(System.lineSeparator());
            stringBuilder.append(String.format("##Gold - %d", this.gold)).append(System.lineSeparator());
        }
        if (!this.gem.isEmpty()) {
            stringBuilder.append(String.format("<Gem> $%d", getTotalGems())).append(System.lineSeparator());
            this.gem.entrySet().stream().sorted((g1, g2) -> {
                int res = g2.getKey().compareTo(g1.getKey());
                if (res == 0) {
                    res = g1.getValue().compareTo(g2.getValue());
                }
                return res;
            }).forEach(entry -> stringBuilder.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator()));
        }
        if (!this.cash.isEmpty()) {
            stringBuilder.append(String.format("<Cash> $%d", getTotalCash())).append(System.lineSeparator());
            this.cash.entrySet().stream().sorted((c1, c2) -> {
                int res = c2.getKey().compareTo(c1.getKey());
                if (res == 0) {
                    res = c1.getValue().compareTo(c2.getValue());
                }
                return res;
            }).forEach(entry -> stringBuilder.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator()));
        }
        System.out.printf("%s", stringBuilder.toString().trim());
    }

    public boolean hasFreeCapacity(long amount) {
        return this.currentCapacity + amount <= this.capacity;
    }

    private long getTotalGems() {
        return this.gem.values().stream().mapToLong(e -> e).sum();
    }

    private long getTotalCash() {
        return this.cash.values().stream().mapToLong(e -> e).sum();
    }
}
