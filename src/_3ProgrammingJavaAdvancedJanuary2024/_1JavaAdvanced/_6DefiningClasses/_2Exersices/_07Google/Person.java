package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._6DefiningClasses._2Exersices._07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> childrens;
    private List<Pokemon> pokemon;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
        this.pokemon = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void setChildren(List<Children> childrens) {
        this.childrens = childrens;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }
    public void addParent(Parents parent) {
        this.parents.add(parent);
    }
    public void addChildren(Children children) {
        this.childrens.add(children);
    }
    public void printPersonInfo(Person person) {
        System.out.printf("%s%n", person.getName());
        System.out.printf("Company:%n");
        if (!(person.getCompany() == null)) {
            System.out.printf("%s %s %.2f%n", person.getCompany().getCompanyName(), person.getCompany().getDepartment(), person.getCompany().getSalary());
        }
        System.out.printf("Car:%n");
        if (!(person.getCar() == null)) {
            System.out.printf("%s %d%n", person.getCar().getCarModel(), person.getCar().getCarSpeed());
        }
        System.out.printf("Pokemon:%n");
        if (!(person.getPokemon().isEmpty())) {
            person.getPokemon().forEach(pokemon -> {
                System.out.printf("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType());
            });
        }
        System.out.printf("Parents:%n");
        if (!(person.getParents().isEmpty())) {
            person.getParents().forEach(parents -> {
                System.out.printf("%s %s%n", parents.getParentName(), parents.getParentBirthday());
            });
        }
        System.out.printf("Children:%n");
        if (!(person.getChildrens().isEmpty())) {
            person.getChildrens().forEach(children -> {
                System.out.printf("%s %s%n", children.getChildName(), children.getChildBirthday());
            });
        }
    }
}
