package homework.homework_1;

import ConsoleColors.ConsoleColors;
import homework.unit_base.UnitBase;
import homework_1.ConsolePrinter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsolePrinterTest extends UnitBase {

    @Test
    void givenNoArgs_whenRun_thenExitWOPrint() {
        String[] args = new String[]{};
        ConsolePrinter.main(args);
        assertEquals("", getOutputLines()[0]);
    }

    @Test
    void givenNullArg_whenRun_thenNPEThrown() {
        String[] args = new String[]{null};
        assertThrows(NullPointerException.class, () -> {
            ConsolePrinter.main(args);
        });
    }

    @Test
    void givenOne_NOT_ERROR_Line_whenRun_thenPrintsOneLine() {
        String[] args = new String[]{"oneNotErrorLine"};
        ConsolePrinter.main(args);
        String expected = args[0] + ": " + args[0].length() + " letter(s)" ;
        assertEquals(expected, getOutputLines()[0]);
    }

    @Test
    void givenError_whenRun_thenRedAlarmPrinted() {
        String[] args = new String[]{"error"};
        ConsolePrinter.main(args);
        String expected = "[0;31mAlarm![0m";
        assertEquals(expected, getOutputLines()[0]);
    }

    @Test
    void givenThreeStringsAndError_whenRun_thenStringsPrintedAndRedAlarmPrinted() {
        String[] args = new String[]{"first","second","third","error"};
        ConsolePrinter.main(args);
        assertEquals(getOutputLines()[0], "first" + ": " + "first".length() + " letter(s)");
        assertEquals(getOutputLines()[1], "second" + ": " + "second".length() + " letter(s)");
        assertEquals(getOutputLines()[2], "third" + ": " + "third".length() + " letter(s)");
        assertTrue(getOutputLines()[3].contains("Alarm!"));
    }

}
