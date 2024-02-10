package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._3Inheritance._2Exersices._06Animals.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public abstract String produceSound();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public void setGender(String gender) {
        if (!gender.trim().isEmpty()) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid input!");
        }
    }


    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.name, this.age, this.gender, this.produceSound());
    }
}
