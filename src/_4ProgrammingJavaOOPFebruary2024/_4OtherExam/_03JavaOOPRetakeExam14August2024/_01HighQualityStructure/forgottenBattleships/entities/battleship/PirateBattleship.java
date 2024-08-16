package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._01HighQualityStructure.forgottenBattleships.entities.battleship;

public class PirateBattleship extends BaseBattleship {
    public PirateBattleship(String name, int health) {
        super(name, health, 80, 10);
    }

    @Override
    public void attack(Battleship battleship) {
        super.setAmmunition(super.getAmmunition() - 10);
    }

    @Override
    public void takeDamage(Battleship battleship) {
        super.setHealth(super.getHealth() - battleship.getHitStrength());
    }
}
