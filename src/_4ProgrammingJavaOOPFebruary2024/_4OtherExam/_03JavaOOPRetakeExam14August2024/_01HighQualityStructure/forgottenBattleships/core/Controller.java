package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.core;

import _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battlezone.BattleZone;

public interface Controller {

    String addBattleZone(String battleZoneName, int capacity);

    BattleZone getBattleZoneByName(String battleZoneName);

    String addBattleshipToBattleZone(String battleZoneName, String shipType, String shipName, int health);

    String startBattle(String battleZoneName, String attackingShip, String shipUnderAttack);

    String getStatistics();


}
