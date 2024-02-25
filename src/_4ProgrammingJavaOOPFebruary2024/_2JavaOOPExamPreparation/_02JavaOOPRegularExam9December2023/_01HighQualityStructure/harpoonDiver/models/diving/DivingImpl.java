package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.diving;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.diver.Diver;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;

public class DivingImpl implements Diving{
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        Collection<String> divingSits = divingSite.getSeaCreatures();
        for (Diver diver : divers) {
            while (diver.canDive() && divingSits.iterator().hasNext()) {
                diver.shoot();
                String currentDivingSits = divingSits.iterator().next();
                diver.getSeaCatch().getSeaCreatures().add(currentDivingSits);
                divingSits.remove(currentDivingSits);
            }
        }
    }
}
