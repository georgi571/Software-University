package _3ProgrammingJavaAdvancedJanuary2024._1JavaAdvanced._9IteratorsAndComparators._1Lab._03ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book (String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book otherBook) {
        int resultTitle = this.title.compareTo(otherBook.getTitle());
        if (resultTitle == 0) {
            resultTitle = Integer.compare(this.year, otherBook.year);

        }
        return resultTitle;
    }
}
