package homework_4_test.singleton;

import homework_4.singleton.Theater;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TheaterTest {

    @Test
    void givenInstance_whenBookSeat_thenTrue() {
        Theater theater = Theater.getInstance();
        assertTrue(theater.bookSeat(1, 1));
    }

    @Test
    void givenSecondInstance_whenBookSeat_thenFalse() {
        Theater theater = Theater.getInstance();
        Theater theater2 = Theater.getInstance();

        theater.bookSeat(1, 1);

        assertFalse(theater2.bookSeat(1, 1));
    }

    @Test
    void givenIllegalSeatValue_whenBookSeat_thenFalse() {
        Theater theater = Theater.getInstance();

        assertFalse(theater.bookSeat(0, 0));
        assertFalse(theater.bookSeat(-1, -1));
        assertFalse(theater.bookSeat(21, 11));
    }
}
