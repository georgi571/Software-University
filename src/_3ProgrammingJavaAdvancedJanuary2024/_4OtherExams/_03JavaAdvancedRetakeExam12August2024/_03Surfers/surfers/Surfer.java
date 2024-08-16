package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._03JavaAdvancedRetakeExam12August2024._03Surfers.surfers;

public class Surfer {
    private String name;
    private int age;
    private int experience;
    private Boolean ownsASurfBoard;
    private int money;

    public Surfer(String name, int age, int experience, Boolean ownsASurfBoard, int money) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownsASurfBoard = ownsASurfBoard;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Boolean getOwnsASurfBoard() {
        return ownsASurfBoard;
    }

    public void setOwnsASurfBoard(Boolean ownsASurfBoard) {
        this.ownsASurfBoard = ownsASurfBoard;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format(" Surfer %s is %d years old and has %d years surfing experience.",this.name , this.age, this.experience);
    }
}
