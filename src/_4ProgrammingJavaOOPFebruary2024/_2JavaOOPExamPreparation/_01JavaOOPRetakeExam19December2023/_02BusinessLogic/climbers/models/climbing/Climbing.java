package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climbing;

import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.climber.Climber;
import _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._01JavaOOPRetakeExam19December2023._02BusinessLogic.climbers.models.mountain.Mountain;

import java.util.Collection;

public interface Climbing {
    void conqueringPeaks(Mountain mountain, Collection<Climber> climbers);

}
