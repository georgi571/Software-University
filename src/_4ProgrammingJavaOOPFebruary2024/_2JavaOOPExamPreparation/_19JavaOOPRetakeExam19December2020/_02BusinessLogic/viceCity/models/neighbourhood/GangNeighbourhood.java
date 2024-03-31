package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.neighbourhood;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Gun gun : mainPlayer.getGunRepository().getModels()) {
            for (Player civilPlayer : civilPlayers) {
                while (gun.canFire() && civilPlayer.isAlive()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
            }
        }
        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                while (gun.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }
            }
        }
    }
}
