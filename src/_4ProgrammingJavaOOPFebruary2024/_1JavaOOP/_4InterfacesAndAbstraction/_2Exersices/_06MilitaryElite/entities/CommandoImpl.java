package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.entities;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces.Commando;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missionsList;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missionsList = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        missionsList.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableList(missionsList);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())).append(System.lineSeparator());
        stringBuilder.append("Corps: ").append(corp).append(System.lineSeparator());
        stringBuilder.append("Missions:").append(System.lineSeparator());
        for (Mission mission : missionsList) {
            stringBuilder.append(" ").append(mission.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
