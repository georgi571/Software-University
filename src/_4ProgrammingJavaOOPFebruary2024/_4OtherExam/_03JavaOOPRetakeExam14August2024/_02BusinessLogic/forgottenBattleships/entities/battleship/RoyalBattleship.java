package _4ProgrammingJavaOOPFebruary2024._4OtherExam._03JavaOOPRetakeExam14August2024._02BusinessLogic.forgottenBattleships.entities.battleship;

public class RoyalBattleship extends BaseBattleship {
    public RoyalBattleship(String name, int health) {
        super(name, health, 100, 25);
    }


    @Override
    public void attack(Battleship battleship) {
        super.setAmmunition(super.getAmmunition() - 25);
    }

    @Override
    public void takeDamage(Battleship battleship) {
        super.setHealth(super.getHealth() - battleship.getHitStrength());
    }
}
