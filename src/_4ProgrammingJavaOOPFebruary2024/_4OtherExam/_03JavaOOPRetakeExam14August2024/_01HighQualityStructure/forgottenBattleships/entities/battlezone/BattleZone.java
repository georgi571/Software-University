package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battlezone;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battleship.Battleship;

import java.util.Collection;

public interface BattleZone {

    String getName();

    int getCapacity();

    void addBattleship(Battleship ship);

    Battleship getBattleshipByName(String battleshipName);

    void removeBattleShip(Battleship ship);

    Collection<Battleship> getShips();


}
