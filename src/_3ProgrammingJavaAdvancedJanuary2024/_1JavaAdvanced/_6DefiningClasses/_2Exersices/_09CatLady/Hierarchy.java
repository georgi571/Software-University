package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._09CatLady;

public class Hierarchy {
    private String breeds;
    private String name;
    private double earSize;
    private double furLength;
    private double decibelsOfMeows;

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    public void setDecibelsOfMeows(double decibelsOfMeows) {
        this.decibelsOfMeows = decibelsOfMeows;
    }
    public void printCatInfo(Hierarchy hierarchy) {
        System.out.printf("%s %s ", getBreeds(), getName());
        if (getBreeds().equals("Siamese")) {
            System.out.printf("%.2f%n", getEarSize());
        } else if (getBreeds().equals("Cymric")) {
            System.out.printf("%.2f%n", getFurLength());
        } else if (getBreeds().equals("StreetExtraordinaire")) {
            System.out.printf("%.2f%n", getDecibelsOfMeows());
        }
    }
}
