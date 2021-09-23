package homework_3;

import base.UnitBase;
import homework_2.traffic_light.TrafficLight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest extends UnitBase {
    @Test
    void testImmutableClass() {
        Book book1 = new Book("Test-Driven Java Development", 2015, " Viktor Farcic",
                "Alex Garcia");
        Book book2 = book1.changeTitle("Test-Driven Java Development");
        assertNotEquals(book1, book2);
        assertEquals("Test-Driven Java Development", book1.getTitle());
        assertEquals(book2.getTitle(), book1.getTitle());
    }


}