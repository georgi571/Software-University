package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battleship;

public interface Battleship {

    String getName();

    int getHealth();

    int getHitStrength();

    int getAmmunition();

    void attack(Battleship battleship);

    void takeDamage(Battleship battleship);


}
