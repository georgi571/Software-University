package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._08FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private String dateOfBirth;
    private List<Parents> parents;
    private List<Childrens> childrens;

    public Person() {
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Childrens> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Childrens> childrens) {
        this.childrens = childrens;
    }

    public void addParents(Parents parent) {
        this.parents.add(parent);
    }

    public void addChildren(Childrens children) {
        this.childrens.add(children);
    }

    public void printPersonInfo() {
        System.out.printf("%s %s%n", getName(), getDateOfBirth());
        System.out.printf("Parents:%n");
        for (int i = 0; i < getParents().size(); i++) {
            System.out.printf("%s %s%n", getParents().get(i).getName(), getParents().get(i).getBirthdayDate());
        }
        System.out.printf("Children:%n");
        for (int i = 0; i < getChildrens().size(); i++) {
            System.out.printf("%s %s%n", getChildrens().get(i).getName(), getChildrens().get(i).getDateOfBirth());
        }
    }
}
