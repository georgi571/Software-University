package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.mission;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.astronauts.Astronaut;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._17JavaOOPRetakeExam18April2021._02BusinessLogic.spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        Collection<String> items = planet.getItems();
        for (Astronaut astronaut : astronauts) {
            while (astronaut.canBreath() && items.iterator().hasNext()) {
                String item = items.iterator().next();
                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                items.remove(item);
            }
        }
    }
}
