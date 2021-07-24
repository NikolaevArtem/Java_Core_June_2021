package homework_3;

import java.util.*;

public final class Book {

    private final String title;
    private final int year;
    private final String[] authors;

    public Book(String name, int age,String... authors) {
        this.title = name;
        this.year = age;
        this.authors = authors;
    }

    public Book(String name, String... authors) {
        this.title = name;
        this.year = 0;
        this.authors = authors;
    }

    public Book(String name, int age) {
        this.title = name;
        this.year = age;
        this.authors = new String[0];
    }

    public Book() {
        this.title = "";
        this.year = 0;
        this.authors = new String[0];
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return Arrays.asList(authors);
    }

    public Book changeTitle(String title) {
        return new Book(title, year, authors);
    }
}
