package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._01JavaAdvancedRetakeExam10April2024._03Spacecrafts.spaceCrafts;

import java.util.ArrayList;
import java.util.List;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new ArrayList<>();
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < capacity) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.printf("This launchpad is at full capacity!%n");
        }
    }

    public boolean removeSpacecraft(String name) {
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                this.spacecrafts.remove(spacecraft);
                return true;
            }
        }
        return false;
    }

    public String getHeaviestSpacecraft() {
        Spacecraft spacecraftToReturn = null;
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraftToReturn == null) {
                spacecraftToReturn = spacecraft;
            } else {
                if (spacecraft.getWeight() > spacecraftToReturn.getWeight()) {
                    spacecraftToReturn = spacecraft;
                }
            }
        }
        return String.format("%s - %dkg.", spacecraftToReturn.getName(), spacecraftToReturn.getWeight());
    }

    public Spacecraft getSpacecraft(String name) {
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getName().equals(name)) {
                return spacecraft;
            }
        }
        return null;
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> spacecraftList = new ArrayList<>();
        for (Spacecraft spacecraft : this.spacecrafts) {
            if (spacecraft.getMissionType().equals(missionType)) {
                spacecraftList.add(spacecraft);
            }
        }
        if (spacecraftList.isEmpty()) {
            System.out.printf("There are no spacecrafts to respond this criteria.%n");
        }
        return spacecraftList;
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Spacecrafts launched from %s:",this.name)).append(System.lineSeparator()).trimToSize();
        for (int i = 0; i < this.spacecrafts.size(); i++) {
            stringBuilder.append(String.format("%d. %s",i + 1,this.spacecrafts.get(i).getName())).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
