package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._01JavaAdvancedRetakeExam10April2024._03Spacecrafts.spaceCrafts;

public class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String objective;
    private int weight;

    public Spacecraft(String name, String missionType, String target, String objective, int weight) {
        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.objective = objective;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("The mission of %s was to reach %s and to %s", this.name, this.target, this.objective);
    }
}
