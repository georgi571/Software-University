package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.region;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._02BusinessLogic.magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = new ArrayList<>();
        List<Magician> blackWidows = new ArrayList<>();
        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizards.add(magician);
            } else {
                blackWidows.add(magician);
            }
        }
        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            for (Magician wizard : wizards) {
                for (int i = 0; i < blackWidows.size(); i++) {
                    blackWidows.get(i).takeDamage(wizard.getMagic().fire());
                    if (!blackWidows.get(i).isAlive()) {
                        blackWidows.remove(i);
                        i--;
                    }
                }
            }
            for (Magician blackWidow : blackWidows) {
                for (int i = 0; i < wizards.size(); i++) {
                    wizards.get(i).takeDamage(blackWidow.getMagic().fire());
                    if (!wizards.get(i).isAlive()) {
                        wizards.remove(i);
                        i--;
                    }
                }
            }
        }
        if (wizards.isEmpty()) {
            return String.format("Black widows win!");
        }
        return String.format("Wizards win!");
    }
}
