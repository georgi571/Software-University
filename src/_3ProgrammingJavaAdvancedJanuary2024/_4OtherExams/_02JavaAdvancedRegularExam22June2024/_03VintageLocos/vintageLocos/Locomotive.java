package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._02JavaAdvancedRegularExam22June2024._03VintageLocos.vintageLocos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Locomotive {
    private String name;
    private String builder;
    private LocalDate buildDate;
    private int gauge;
    private int weight;
    private int maxSpeed;

    public Locomotive(String name, String builder, LocalDate buildDate, int gauge, int weight, int maxSpeed) {
        this.name = name;
        this.builder = builder;
        this.buildDate = buildDate;
        this.gauge = gauge;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }

    public int getGauge() {
        return gauge;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        String date = this.buildDate.format(formatters);
        return String.format("This %s is made by %s at %s.", this.name, this.builder, date);
    }
}
