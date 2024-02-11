package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.entities;


import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces.LieutenantGeneral;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces.Soldier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Soldier> privatesList;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {

        super(id, firstName, lastName, salary);
        this.privatesList = new ArrayList<>();
    }

    public void addPrivate(Soldier soldier) {
        privatesList.add(soldier);
    }

    @Override
    public List<Soldier> getPrivates() {
        return Collections.unmodifiableList(privatesList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f", getFirstName(), getLastName(), getId(), getSalary())).append(System.lineSeparator());
        stringBuilder.append("Privates:").append(System.lineSeparator());
        for (Soldier soldier : privatesList) {
            stringBuilder.append(" ").append(soldier.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
