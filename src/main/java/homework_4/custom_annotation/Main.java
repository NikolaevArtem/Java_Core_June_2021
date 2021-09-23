package homework_4.custom_annotation;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        Book book = new Book("My Book");
        book.setAuthor("Someone");
        book.setGenre("fantasy");
        book.setCost(300.0);
        book.printImportant();
    }

}
