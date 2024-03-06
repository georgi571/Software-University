package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climbing;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber.Climber;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain.Mountain;

import java.util.Collection;

public class ClimbingImpl implements Climbing {

    @Override
    public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
        Collection<String> peaks = mountain.getPeaksList();
        for (Climber climber : climbers) {
            while (climber.canClimb() && peaks.iterator().hasNext()) {
                climber.climb();
                String currentPeak = peaks.iterator().next();
                climber.getRoster().getPeaks().add(currentPeak);
                peaks.remove(currentPeak);
            }
        }
    }
}
