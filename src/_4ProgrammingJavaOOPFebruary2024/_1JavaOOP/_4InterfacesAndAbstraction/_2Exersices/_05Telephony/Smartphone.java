package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._05Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder browsedURLs = new StringBuilder();
        for (String url : this.urls) {
            if (!url.matches(".*\\d.*")) {
                browsedURLs.append("Browsing: ").append(url).append("!").append(System.lineSeparator());
            } else {
                browsedURLs.append("Invalid URL!").append(System.lineSeparator());
            }
        }
        return browsedURLs.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder calledNumbers = new StringBuilder();
        for (String number : this.numbers) {
            if (!number.matches(".*[A-Za-z].*")) {
                calledNumbers.append("Calling... ").append(number).append(System.lineSeparator());
            } else {
                calledNumbers.append("Invalid number!").append(System.lineSeparator());
            }
        }
        return calledNumbers.toString().trim();
    }
}
