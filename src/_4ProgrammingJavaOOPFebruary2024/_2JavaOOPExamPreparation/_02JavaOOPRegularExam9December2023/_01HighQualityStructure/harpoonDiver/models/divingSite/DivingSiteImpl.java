package _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.models.divingSite;

import java.util.Collection;
import java.util.List;

import static _4ProgrammingJavaOOPFebruary2024._2JavaOOPExamPreparation._02JavaOOPRegularExam9December2023._01HighQualityStructure.harpoonDiver.common.ExceptionMessages.SITE_NAME_NULL_OR_EMPTY;

public class DivingSiteImpl implements DivingSite{
    private String name;
    private List<String> seaCreatures;

    public DivingSiteImpl(String name) {
        this.name = name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
