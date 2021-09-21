package homework_4.custom_annotation;

@Author
public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        if (author == null || author.isEmpty()) {
            Author defaultAuthor = (Author) this.getClass().getDeclaredAnnotations()[0];
            this.author = defaultAuthor.value();
        } else {
            this.author = author;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
