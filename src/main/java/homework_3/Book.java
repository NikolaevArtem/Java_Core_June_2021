package homework_3;

import java.util.Arrays;

public final class Book {

    private final String title;
    private final int year;
    private final String[] authors;

    public Book(String name, int age, String... authors) {
        this.title = name;
        this.year = age;
        this.authors = Arrays.copyOf(authors, authors.length);
    }

    public Book(String name, String... authors) {
        this.title = name;
        this.year = 0;
        this.authors = Arrays.copyOf(authors, authors.length);
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

    public String[] getAuthors() {
        return Arrays.copyOf(authors, authors.length);
    }

    public Book changeTitle(String title) {
        return new Book(title, year, Arrays.copyOf(authors, authors.length));
    }
}