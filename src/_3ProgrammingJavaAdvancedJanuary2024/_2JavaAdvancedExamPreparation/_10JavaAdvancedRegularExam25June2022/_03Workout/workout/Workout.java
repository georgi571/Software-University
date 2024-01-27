package _3ProgrammingJavaAdvancedJanuary2024._2JavaAdvancedExamPreparation._10JavaAdvancedRegularExam25June2022._03Workout.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return this.exercises.remove(exercise);
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise mostBurnedCalories = null;
        for (Exercise exercise : this.exercises) {
            if (mostBurnedCalories == null) {
                mostBurnedCalories = exercise;
            } else  {
                if (exercise.getBurnedCalories() > mostBurnedCalories.getBurnedCalories()) {
                    mostBurnedCalories = exercise;
                }
            }
        }
        return mostBurnedCalories;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Workout type: %s%n", this.type));
        for (Exercise exercise : this.exercises) {
            stringBuilder.append(String.format("%s%n", exercise.toString()));
        }
        return stringBuilder.toString();
    }
}
