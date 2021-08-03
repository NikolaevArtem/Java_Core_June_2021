package homework_4.custom_annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    private static final String DEFAULT_AUTHOR = "unknown";

    @Test
    void givenNull_getDefault() {
        Book book = new Book("Harry Potter", null);
        assertEquals(DEFAULT_AUTHOR, book.getAuthor());
    }

    @Test
    void givenEmptyString_getDefault() {
        Book book = new Book("Lord Of The Rings", "");
        assertEquals(DEFAULT_AUTHOR, book.getAuthor());
    }

    @Test
    void givenAuthor_getAuthor() {
        Book book = new Book("Alice's Adventures In Wonderland", "Lewis Carroll");
        assertEquals("Lewis Carroll", book.getAuthor());
    }

    @Test
    void givenName_getName(){
        Book book = new Book("The Adventures of Tom Sawyer", "Mark Twain");
        assertEquals("Mark Twain", book.getName());
    }

}
