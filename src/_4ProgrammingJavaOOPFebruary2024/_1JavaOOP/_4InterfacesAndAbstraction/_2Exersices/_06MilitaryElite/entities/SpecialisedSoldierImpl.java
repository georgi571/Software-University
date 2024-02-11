package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.entities;

import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.enums.Corps;
import _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    Corps corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    private void setCorp(String corp) {
        if (!corp.equals("Airforces") && !corp.equals("Marines")) {
            throw new IllegalArgumentException("Invalid corp!");
        }
        this.corp = Corps.valueOf(corp);
    }

    @Override
    public Corps getCorp() {
        return corp;
    }
}
