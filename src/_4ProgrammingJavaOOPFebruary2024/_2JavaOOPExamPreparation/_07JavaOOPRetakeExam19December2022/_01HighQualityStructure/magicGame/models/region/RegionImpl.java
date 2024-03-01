package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.models.region;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._07JavaOOPRetakeExam19December2022._01HighQualityStructure.magicGame.models.magicians.Magician;

import java.util.Collection;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        Collection<Magician> wizards = null;
        Collection<Magician> blackWidows = null;
        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizards.add(magician);
            } else {
                blackWidows.add(magician);
            }
        }
        if (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            Magician currentWizard = wizards.iterator().next();
            Magician currentBlackWidows = blackWidows.iterator().next();;
            while (!wizards.iterator().hasNext() && !blackWidows.iterator().hasNext())
                if (currentWizard.getMagic().getBulletsCount() > 0) {
                    currentWizard.getMagic().fire();
                    currentBlackWidows.takeDamage(currentWizard.getMagic().fire());
                }
            if (currentBlackWidows.getMagic().getBulletsCount() > 0) {
                currentBlackWidows.getMagic().fire();
                currentWizard.takeDamage(currentBlackWidows.getMagic().fire());
            }
            if (!currentWizard.isAlive()) {
                wizards.remove(currentWizard);
                if (wizards.iterator().hasNext()) {
                    currentWizard = wizards.iterator().next();
                }
            }
            if (!currentBlackWidows.isAlive()) {
                blackWidows.remove(currentBlackWidows);
                if (blackWidows.iterator().hasNext()) {
                    currentBlackWidows = blackWidows.iterator().next();
                }
            }
        }
        if (wizards.isEmpty()) {
            return String.format("Wizards win!");
        }

        return String.format("Black widows win!");
    }
}
