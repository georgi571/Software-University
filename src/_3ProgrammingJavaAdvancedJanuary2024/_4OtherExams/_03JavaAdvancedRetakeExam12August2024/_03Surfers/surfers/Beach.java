package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._03JavaAdvancedRetakeExam12August2024._03Surfers.surfers;

import java.util.ArrayList;
import java.util.List;

public class Beach {
    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new ArrayList<>();
    }

    public String addSurfer(Surfer surfer) {
        if (surfer.getOwnsASurfBoard()) {
            this.surfers.add(surfer);
            return String.format("Surfer %s added.", surfer.getName());
        } else if (this.surfboardsForRent > 0) {
            if (!surfer.getOwnsASurfBoard() && surfer.getMoney() >= 50) {
                this.surfers.add(surfer);
                surfer.setMoney(surfer.getMoney() - 50);
                this.surfboardsForRent--;
                return String.format("Surfer %s added.", surfer.getName());
            } else {
                return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
            }
        }
        return String.format("There are no free surfboards.");
    }

    public boolean removeSurfer(String name) {
        for (Surfer surfer : this.surfers) {
            if (surfer.getName().equals(name)) {
                return this.surfers.remove(surfer);
            }
        }
        return false;
    }

    public String getMostExperiencedSurfer() {
        Surfer mostExperiencedSurfer = null;
        int mostExperience = 0;
        for (Surfer surfer : this.surfers) {
            if (surfer.getExperience() > mostExperience) {
                mostExperiencedSurfer = surfer;
                mostExperience = surfer.getExperience();
            }
        }
        if (mostExperiencedSurfer != null) {
            return String.format("%s is most experienced surfer with %d years experience.", mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
        }
        return String.format("There are no surfers.");
    }

    public Surfer getSurfer(String name) {
        for (Surfer surfer : this.surfers) {
            if (surfer.getName().equals(name)) {
                return surfer;
            }
        }
        return null;
    }

    public int getCount() {
        return this.surfers.size();
    }

    public String getSurfersWithPersonalSurfboards() {
        StringBuilder names = new StringBuilder();
        for (Surfer surfer : this.surfers) {
            if (surfer.getOwnsASurfBoard()) {
                if (names.isEmpty()) {
                    names.append(String.format("%s", surfer.getName()));
                } else {
                    names.append(String.format(", %s", surfer.getName()));
                }
            }
        }
        if (!names.isEmpty()) {
            return String.format("Surfers who have their own surfboards: %s", names);
        }
        return String.format("There are no surfers.");
    }

    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.surfers.isEmpty()) {
            stringBuilder.append(String.format("Beach %s was visited by the following surfers:", this.name)).append(System.lineSeparator());
            for (int i = 0; i < this.surfers.size(); i++) {
                int position = i + 1;
                if (surfers.get(i).getExperience() == 0) {
                    stringBuilder.append(String.format("%d. %s with no experience.", position, surfers.get(i).getName())).append(System.lineSeparator());
                } else {
                    stringBuilder.append(String.format("%d. %s with %d years experience.", position, surfers.get(i).getName(), surfers.get(i).getExperience())).append(System.lineSeparator());
                }
            }
            return stringBuilder.toString().trim();
        }
        return String.format("There are no surfers on %s beach.", this.name);
    }
}
