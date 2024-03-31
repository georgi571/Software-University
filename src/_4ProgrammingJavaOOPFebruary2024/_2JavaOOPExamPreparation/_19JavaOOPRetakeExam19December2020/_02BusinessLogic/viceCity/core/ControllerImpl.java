package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.core;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.core.interfaces.Controller;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.guns.Gun;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.guns.Pistol;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.guns.Rifle;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.neighbourhood.GangNeighbourhood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.neighbourhood.Neighbourhood;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.players.CivilPlayer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.players.MainPlayer;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.models.players.Player;

import java.util.*;
import java.util.stream.Collectors;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._19JavaOOPRetakeExam19December2020._02BusinessLogic.viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {

    private Player mainPlayer;
    private Collection<Player> civilPlayers;
    private Deque<Gun> guns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
    }


    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        } else {
            return String.format(GUN_TYPE_INVALID);
        }
        this.guns.add(gun);
        return String.format(GUN_ADDED, name, type);
    }

    @Override
    public String addGunToPlayer(String name) {
        Player player = null;
        Gun gun = null;
        if (this.guns.isEmpty()) {
            return String.format(GUN_QUEUE_IS_EMPTY);
        } else {
            gun = this.guns.iterator().next();
        }
        if (name.equals("Vercetti")) {
            this.mainPlayer.getGunRepository().add(gun);
            this.guns.remove(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        } else {
            for (Player civilPlayer : this.civilPlayers) {
                if (civilPlayer.getName().equals(name)) {
                    player = civilPlayer;
                    player.getGunRepository().add(gun);
                    this.guns.remove(gun);
                    break;
                }
            }
            if (player == null) {
                return String.format(CIVIL_PLAYER_DOES_NOT_EXIST);
            }
        }
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), player.getName());
    }


    @Override
    public String fight() {
        StringBuilder report = new StringBuilder();
        Neighbourhood neighbourhood = new GangNeighbourhood();
        neighbourhood.action(mainPlayer, this.civilPlayers);
        boolean isEverythingOk = true;
        for (Player civilPlayer : this.civilPlayers) {
            if (civilPlayer.getLifePoints() < 50) {
                isEverythingOk = false;
                break;
            }
        }
        List<Player> deadPlayers = this.civilPlayers.stream().filter(player1 -> !player1.isAlive()).collect(Collectors.toList());
        long countAlive = this.civilPlayers.stream().filter(Player::isAlive).count();
        if (this.mainPlayer.getLifePoints() == 100 && isEverythingOk) {
            return String.format(FIGHT_HOT_HAPPENED);
        }
        report.append(FIGHT_HAPPENED).append(System.lineSeparator());
        report.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, this.mainPlayer.getLifePoints())).append(System.lineSeparator());
        report.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers.size())).append(System.lineSeparator());
        report.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, countAlive)).append(System.lineSeparator());
        for (int i = 0; i < deadPlayers.size(); i++) {
            this.civilPlayers.remove(this.civilPlayers.iterator().next());
        }
        return report.toString().trim();
    }
}