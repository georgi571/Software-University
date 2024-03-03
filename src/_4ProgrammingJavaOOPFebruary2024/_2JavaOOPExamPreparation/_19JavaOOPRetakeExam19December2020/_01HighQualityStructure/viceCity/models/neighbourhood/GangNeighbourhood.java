package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.neighbourhood;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._01HighQualityStructure.viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Player currentPlayer = null;
        if (!mainPlayer.getGunRepository().getModels().isEmpty()) {
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {
                while (gun.canFire() && civilPlayers.iterator().hasNext()) {
                    if (currentPlayer == null || !currentPlayer.isAlive()) {
                        currentPlayer = civilPlayers.iterator().next();
                    }
                    currentPlayer.takeLifePoints(gun.fire());
                }
            }
        } else {
            for (Player civilPlayer : civilPlayers) {
                for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                    while (gun.canFire() && mainPlayer.isAlive()) {
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                }
            }
        }
    }
}
