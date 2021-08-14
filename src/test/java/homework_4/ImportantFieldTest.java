package homework_4;

import homework_4.custom_annotation.Book;
import homework_4.custom_annotation.ImportantField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportantFieldTest extends base.UnitBase {

    private Book book;

    @BeforeEach
    void init() {
        book = new Book("Some book");
    }

    @Test
    void annotationTest() throws NoSuchFieldException {
        ArrayList<Field> importantFields = new ArrayList<>();
        for (Field field : book.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantField.class)) {
                importantFields.add(field);
            }
        }

        assertEquals(4, importantFields.size());
        assertEquals(1, book.getClass().getDeclaredField("title")
                .getAnnotation(ImportantField.class).priority());
        assertEquals(2, book.getClass().getDeclaredField("author")
                .getAnnotation(ImportantField.class).priority());
        assertEquals(3, book.getClass().getDeclaredField("genre")
                .getAnnotation(ImportantField.class).priority());
        assertEquals(4, book.getClass().getDeclaredField("cost")
                .getAnnotation(ImportantField.class).priority());
    }

    @Test
    void printImportantTest() throws IllegalAccessException {
        book.setCost(300.0);

        book.printImportant();
        printOut();

        assertEquals(4, getOutputLines().length);
        assertEquals("title: Some book;", getOutputLines()[0]);
        assertTrue(getOutputLines()[1].contains("author"));
        assertTrue(getOutputLines()[2].contains("genre"));
        assertEquals("cost: 300.0;", getOutputLines()[3]);
    }

}
