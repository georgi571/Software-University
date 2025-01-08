package _3ProgrammingJavaAdvancedJanuary2024._4OtherExams._05JavaAdvancedRetakeExam12December2024._03Geoglyphs.geoglyphs;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Location {

    private static final String EXISTING_GEOGLYPH = "This geoglyph exists in the location!";
    private static final String GEOGLYPH_ADDED = "%s added to %s.";
    private static final String GEOGLYPHS_BY_TECHNIQUE = "Geoglyphs made by %s: %s";
    private static final String NO_GEOGLYPHS_BY_TECHNIQUE = "There are no geoglyphs made by %s in this location.";
    private static final String LARGEST_GEOGLYPH = "The largest geoglyph is %s with a length of %d meters.";
    private static final String GEOGLYPHS_IN_LOCATION = "Geoglyphs located in %s:";
    private static final String NO_GEOGLYPHS_DISCOVERED = "No geoglyphs have yet been discovered in %s.";

    private String name;
    private Collection<Geoglyph> geoglyphs;

    public Location(String name) {
        this.name = name;
        this.geoglyphs = new ArrayList<>();
    }

    public String addGeoglyph(Geoglyph geoglyph) {
        for (Geoglyph currentGeoglyphs : this.geoglyphs) {
            if (currentGeoglyphs.getName().equals(geoglyph.getName())) {
                throw new IllegalArgumentException(String.format(EXISTING_GEOGLYPH));
            }
        }
        geoglyphs.add(geoglyph);
        return String.format(GEOGLYPH_ADDED, geoglyph.getName(), this.name);
    }

    public boolean removeGeoglyph(String name) {
        for (Geoglyph currentGeoglyphs : this.geoglyphs) {
            if (currentGeoglyphs.getName().equals(name)) {
                geoglyphs.remove(currentGeoglyphs);
                return true;
            }
        }
        return false;
    }

    public String getGeoglyphsByConstructionTechnique(String constructionTechnique) {
        List<String> geoglyphsNames = new ArrayList<>();

        for (Geoglyph geoglyph : this.geoglyphs) {
            if (geoglyph.getConstructionTechnique().equals(constructionTechnique)) {
                geoglyphsNames.add(geoglyph.getName());
            }
        }

        if (geoglyphsNames.isEmpty()) {
            return String.format(NO_GEOGLYPHS_BY_TECHNIQUE, constructionTechnique);
        }

        return String.format(GEOGLYPHS_BY_TECHNIQUE, constructionTechnique, String.join(", ", geoglyphsNames));
    }

    public String getLargestGeoglyph() {
        Geoglyph geoglyph = null;

        for (Geoglyph currentGeoglyphs : this.geoglyphs) {
            if (geoglyph == null) {
                geoglyph = currentGeoglyphs;
            } else {
                if (currentGeoglyphs.getSize() > geoglyph.getSize()) {
                    geoglyph = currentGeoglyphs;
                }
            }
        }

        return String.format(LARGEST_GEOGLYPH, geoglyph.getName(), geoglyph.getSize());
    }

    public Geoglyph getGeoglyphByName(String name) {
        for (Geoglyph currentGeoglyphs : this.geoglyphs) {
            if (currentGeoglyphs.getName().equals(name)) {
                return currentGeoglyphs;
            }
        }
        return null;
    }

    public int getCount() {
        return this.geoglyphs.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();

        if (!this.geoglyphs.isEmpty()) {
            statistics.append(String.format(GEOGLYPHS_IN_LOCATION, this.name)).append(System.lineSeparator());

            for (Geoglyph geoglyph : this.geoglyphs) {
                statistics.append(String.format("* %s", geoglyph.getName())).append(System.lineSeparator());
            }
        } else {
            statistics.append(String.format(NO_GEOGLYPHS_DISCOVERED, this.name));
        }

        return statistics.toString().trim();
    }
}
