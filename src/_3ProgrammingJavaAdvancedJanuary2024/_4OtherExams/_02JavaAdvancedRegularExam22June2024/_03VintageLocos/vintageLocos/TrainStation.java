package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._02JavaAdvancedRegularExam22June2024._03VintageLocos.vintageLocos;

import java.util.ArrayList;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (this.capacity > this.locomotives.size()) {
            if (railGauge == locomotive.getGauge()) {
                this.locomotives.add(locomotive);
            } else {
                int diff = Math.abs(this.railGauge - locomotive.getGauge());
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.%n",diff);
            }
        } else {
            System.out.printf("This train station is full!");
        }
    }

    public boolean removeLocomotive(String name) {
        Locomotive locomotive = this.getLocomotive(name);
        if (locomotive == null) {
            return false;
        } else {
            this.locomotives.remove(locomotive);
            return true;
        }
    }

    public String getFastestLocomotive() {
        Locomotive locomotive = null;
        for (Locomotive currentLocomotive : this.locomotives) {
            if (locomotive == null) {
                locomotive = currentLocomotive;
            } else if (currentLocomotive.getMaxSpeed() > locomotive.getMaxSpeed()) {
                locomotive = currentLocomotive;
            }
        }
        if (locomotive == null) {
            return String.format("There are no locomotives.");
        } else {
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.", locomotive.getName(), locomotive.getMaxSpeed());
        }
    }

    public Locomotive getLocomotive(String name) {
        Locomotive locomotive = null;
        for (Locomotive currentLocomotive : this.locomotives) {
            if (currentLocomotive.getName().equals(name)) {
                locomotive = currentLocomotive;
                break;
            }
        }
        return locomotive;
    }

    public int getCount() {
        return this.locomotives.size();
    }

    public String getOldestLocomotive() {
        Locomotive locomotive = null;
        for (Locomotive currentLocomotive : this.locomotives) {
            if (locomotive == null) {
                locomotive = currentLocomotive;
            } else if (currentLocomotive.getBuildDate().isBefore(locomotive.getBuildDate())) {
                locomotive = currentLocomotive;
            }
        }
        if (locomotive == null) {
            return String.format("There are no locomotives.");
        } else {
            return String.format("%s", locomotive.getName());
        }
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.locomotives.isEmpty()) {
            stringBuilder.append(String.format("There are no locomotives departing from %s station.", this.name));
        } else {
            stringBuilder.append(String.format("Locomotives departed from %s:", this.name)).append(System.lineSeparator());
            for (int i = 0; i < this.locomotives.size(); i++) {
                stringBuilder.append(String.format("%d. %s", i + 1 , locomotives.get(i).getName())).append(System.lineSeparator());
            }
        }
        return String.format("%s", stringBuilder);
    }

}
