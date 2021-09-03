package homework_2_tests;

import homework_2.random_chars_table.RandomCharsTable;
import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RandomCharsTableTest extends UnitBase{

    private final String errorMassage = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    private void run(){
        new RandomCharsTable().run();
        removeFromOutput("Please enter number of rows, columns and even|odd:");
        printOut();
    }

    @Test
    void given3_3_even_whenRun_thenValidCase() {
        setInput("3 3 even");

        run();

        assertTrue(getOutput().matches("\\|[A-Z]\\|[A-Z]\\|[A-Z]\\|\\n\\|[A-Z]\\|[A-Z]\\|[A-Z]\\|\\n\\|[A-Z]\\|[A-Z]\\|[A-Z]\\|\\nEven letters - ([BDFHJLNPRTVXZ],)*[BDFHJLNPRTVXZ]*"));

        String endOfLastString = getOutputLines()[3].substring(15);
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 7; j = j + 2) {
                String letter = getOutputLines()[i].substring(j,j+1);
                if (letter.matches("[BDFHJLNPRTVXZ]")) {
                    assertTrue(endOfLastString.contains(letter));
                }
            }
        }
    }

    @Test
    void given2_2_odd_whenRun_thenValidCase() {
        setInput("2 2 odd");

        run();

        assertTrue(getOutput().matches("\\|[A-Z]\\|[A-Z]\\|\\n\\|[A-Z]\\|[A-Z]\\|\\nOdd letters - ([ACEGIKMOQSUWY],)*[ACEGIKMOQSUWY]*"));

        String endOfLastString = getOutputLines()[2].substring(14);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 5; j = j + 2) {
                String letter = getOutputLines()[i].substring(j,j+1);
                if (letter.matches("[ACEGIKMOQSUWY]")) {
                    assertTrue(endOfLastString.contains(letter));
                }
            }
        }
    }

    @Test
    void givenDigitEven_whenRun_thenErrorMassage() {
        setInput("5 even");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDigitsIncorrectWord_whenRun_thenErrorMassage() {
        setInput("5 5 one");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDigitsEvenIncorrectWord_whenRun_thenErrorMassage() {
        setInput("5 5 even one");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenDigitsOnly_whenRun_thenErrorMassage() {
        setInput("5 5 ");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenThreeDigits_whenRun_thenErrorMassage() {
        setInput("5 5 5");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenOddOnly_whenRun_thenErrorMassage() {
        setInput("Odd");

        run();

        assertEquals(errorMassage, getOutput());
    }

    @Test
    void givenIncorrectWordOnly_whenRun_thenErrorMassage() {
        setInput("Five");

        run();

        assertEquals(errorMassage, getOutput());
    }
}
