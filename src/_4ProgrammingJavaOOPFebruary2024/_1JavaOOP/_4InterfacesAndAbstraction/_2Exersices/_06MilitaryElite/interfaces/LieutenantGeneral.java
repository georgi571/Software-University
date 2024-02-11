package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._4InterfacesAndAbstraction._2Exersices._06MilitaryElite.interfaces;

import java.util.Collection;

public interface LieutenantGeneral extends Soldier {
    void addPrivate(Soldier soldier);

    Collection<Soldier> getPrivates();
}
