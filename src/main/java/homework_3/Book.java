package homework_3;

public final class Book {

    private final String title;
    private final int year;
    private final String[] authors;

    public Book(String name, int age, String... authors) {
        this.title = name;
        this.year = age;
        this.authors = authors;
    }

    public Book(String name, String... authors) {
        this.title = name;
        this.year = 0;
        String[] arrayCopy = new String[authors.length];
        System.arraycopy(authors, 0, arrayCopy, 0, authors.length);
        this.authors = arrayCopy;
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
        String[] copyAuthors = new String[this.authors.length];
        System.arraycopy(this.authors, 0, copyAuthors, 0, this.authors.length);
        return copyAuthors;
    }

    public Book changeTitle(String title) {
        return new Book(title, year, authors);
    }
}
