package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.roster;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RosterImpl implements Roster {
    private List<String> peaks;

    public RosterImpl() {
        this.peaks = new ArrayList<>();
    }

    @Override
    public Collection<String> getPeaks() {
        return this.peaks;
    }
}
