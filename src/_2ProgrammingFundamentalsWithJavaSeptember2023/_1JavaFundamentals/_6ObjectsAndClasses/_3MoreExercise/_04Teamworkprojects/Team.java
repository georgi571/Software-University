package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._3MoreExercise._04Teamworkprojects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private String creator;
    private List<String> members = new ArrayList<>();

    public Team(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void addMember(String memberName) {
        members.add(memberName);
    }
    public List<String> getMembers() {
        return members;
    }
    public int membersCount() {
        return members.size();
    }
}
