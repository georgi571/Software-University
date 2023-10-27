package _2ProgrammingFundamentalsWithJavaSeptember2023._1JavaFundamentals._6ObjectsAndClasses._2Exercise._02Articles;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void edit(String newContent) {
        this.content = newContent;
    }
    public void changeAuthor(String newAuthor) {
        this.author = newAuthor;
    }
    public void rename(String newTitle) {
        this.title = newTitle;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
}
