package course_project;

import base.UnitBase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeaBattleTest extends UnitBase {

    private final String allMovesTwice =
            "2\n" + "yes\n" +
                      "A1\n" + " \n" + " \n" + "A2\n" + " \n" + " \n" + "A3\n" + " \n" + " \n" + "A4\n" + " \n" + " \n" + "A5\n" + " \n" + " \n" + "A6\n" + " \n" + " \n" + "A7\n" + " \n" + " \n" + "A8\n" + " \n" + " \n" + "A9\n" + " \n" + " \n" + "A10\n" +
            " \n" + " \n" + "B10\n" +" \n" + " \n" + "B9\n" + " \n" + " \n" + "B8\n" + " \n" + " \n" + "B7\n" + " \n" + " \n" + "B6\n" + " \n" + " \n" + "B5\n" + " \n" + " \n" + "B4\n" + " \n" + " \n" + "B3\n" + " \n" + " \n" + "B2\n" + " \n" + " \n" + "B1\n" +
            " \n" + " \n" + "C10\n" +" \n" + " \n" + "C9\n" + " \n" + " \n" + "C8\n" + " \n" + " \n" + "C7\n" + " \n" + " \n" + "C6\n" + " \n" + " \n" + "C5\n" + " \n" + " \n" + "C4\n" + " \n" + " \n" + "C3\n" + " \n" + " \n" + "C2\n" + " \n" + " \n" + "C1\n" +
            " \n" + " \n" + "D10\n" +" \n" + " \n" + "D9\n" + " \n" + " \n" + "D8\n" + " \n" + " \n" + "D7\n" + " \n" + " \n" + "D6\n" + " \n" + " \n" + "D5\n" + " \n" + " \n" + "D4\n" + " \n" + " \n" + "D3\n" + " \n" + " \n" + "D2\n" + " \n" + " \n" + "D1\n" +
            " \n" + " \n" + "E10\n" +" \n" + " \n" + "E9\n" + " \n" + " \n" + "E8\n" + " \n" + " \n" + "E7\n" + " \n" + " \n" + "E6\n" + " \n" + " \n" + "E5\n" + " \n" + " \n" + "E4\n" + " \n" + " \n" + "E3\n" + " \n" + " \n" + "E2\n" + " \n" + " \n" + "E1\n" +
            " \n" + " \n" + "F10\n" +" \n" + " \n" + "F9\n" + " \n" + " \n" + "F8\n" + " \n" + " \n" + "F7\n" + " \n" + " \n" + "F6\n" + " \n" + " \n" + "F5\n" + " \n" + " \n" + "F4\n" + " \n" + " \n" + "F3\n" + " \n" + " \n" + "F2\n" + " \n" + " \n" + "F1\n" +
            " \n" + " \n" + "G10\n" +" \n" + " \n" + "G9\n" + " \n" + " \n" + "G8\n" + " \n" + " \n" + "G7\n" + " \n" + " \n" + "G6\n" + " \n" + " \n" + "G5\n" + " \n" + " \n" + "G4\n" + " \n" + " \n" + "G3\n" + " \n" + " \n" + "G2\n" + " \n" + " \n" + "G1\n" +
            " \n" + " \n" + "H10\n" +" \n" + " \n" + "H9\n" + " \n" + " \n" + "H8\n" + " \n" + " \n" + "H7\n" + " \n" + " \n" + "H6\n" + " \n" + " \n" + "H5\n" + " \n" + " \n" + "H4\n" + " \n" + " \n" + "H3\n" + " \n" + " \n" + "H2\n" + " \n" + " \n" + "H1\n" +
            " \n" + " \n" + "I10\n" +" \n" + " \n" + "I9\n" + " \n" + " \n" + "I8\n" + " \n" + " \n" + "I7\n" + " \n" + " \n" + "I6\n" + " \n" + " \n" + "I5\n" + " \n" + " \n" + "I4\n" + " \n" + " \n" + "I3\n" + " \n" + " \n" + "I2\n" + " \n" + " \n" + "I1\n" +
            " \n" + " \n" + "J10\n" +" \n" + " \n" + "J9\n" + " \n" + " \n" + "J8\n" + " \n" + " \n" + "J7\n" + " \n" + " \n" + "J6\n" + " \n" + " \n" + "J5\n" + " \n" + " \n" + "J4\n" + " \n" + " \n" + "J3\n" + " \n" + " \n" + "J2\n" + " \n" + " \n" + "J1\n" +
                      "A1\n" + " \n" + " \n" + "A2\n" + " \n" + " \n" + "A3\n" + " \n" + " \n" + "A4\n" + " \n" + " \n" + "A5\n" + " \n" + " \n" + "A6\n" + " \n" + " \n" + "A7\n" + " \n" + " \n" + "A8\n" + " \n" + " \n" + "A9\n" + " \n" + " \n" + "A10\n" +
            " \n" + " \n" + "B10\n" +" \n" + " \n" + "B9\n" + " \n" + " \n" + "B8\n" + " \n" + " \n" + "B7\n" + " \n" + " \n" + "B6\n" + " \n" + " \n" + "B5\n" + " \n" + " \n" + "B4\n" + " \n" + " \n" + "B3\n" + " \n" + " \n" + "B2\n" + " \n" + " \n" + "B1\n" +
            " \n" + " \n" + "C10\n" +" \n" + " \n" + "C9\n" + " \n" + " \n" + "C8\n" + " \n" + " \n" + "C7\n" + " \n" + " \n" + "C6\n" + " \n" + " \n" + "C5\n" + " \n" + " \n" + "C4\n" + " \n" + " \n" + "C3\n" + " \n" + " \n" + "C2\n" + " \n" + " \n" + "C1\n" +
            " \n" + " \n" + "D10\n" +" \n" + " \n" + "D9\n" + " \n" + " \n" + "D8\n" + " \n" + " \n" + "D7\n" + " \n" + " \n" + "D6\n" + " \n" + " \n" + "D5\n" + " \n" + " \n" + "D4\n" + " \n" + " \n" + "D3\n" + " \n" + " \n" + "D2\n" + " \n" + " \n" + "D1\n" +
            " \n" + " \n" + "E10\n" +" \n" + " \n" + "E9\n" + " \n" + " \n" + "E8\n" + " \n" + " \n" + "E7\n" + " \n" + " \n" + "E6\n" + " \n" + " \n" + "E5\n" + " \n" + " \n" + "E4\n" + " \n" + " \n" + "E3\n" + " \n" + " \n" + "E2\n" + " \n" + " \n" + "E1\n" +
            " \n" + " \n" + "F10\n" +" \n" + " \n" + "F9\n" + " \n" + " \n" + "F8\n" + " \n" + " \n" + "F7\n" + " \n" + " \n" + "F6\n" + " \n" + " \n" + "F5\n" + " \n" + " \n" + "F4\n" + " \n" + " \n" + "F3\n" + " \n" + " \n" + "F2\n" + " \n" + " \n" + "F1\n" +
            " \n" + " \n" + "G10\n" +" \n" + " \n" + "G9\n" + " \n" + " \n" + "G8\n" + " \n" + " \n" + "G7\n" + " \n" + " \n" + "G6\n" + " \n" + " \n" + "G5\n" + " \n" + " \n" + "G4\n" + " \n" + " \n" + "G3\n" + " \n" + " \n" + "G2\n" + " \n" + " \n" + "G1\n" +
            " \n" + " \n" + "H10\n" +" \n" + " \n" + "H9\n" + " \n" + " \n" + "H8\n" + " \n" + " \n" + "H7\n" + " \n" + " \n" + "H6\n" + " \n" + " \n" + "H5\n" + " \n" + " \n" + "H4\n" + " \n" + " \n" + "H3\n" + " \n" + " \n" + "H2\n" + " \n" + " \n" + "H1\n" +
            " \n" + " \n" + "I10\n" +" \n" + " \n" + "I9\n" + " \n" + " \n" + "I8\n" + " \n" + " \n" + "I7\n" + " \n" + " \n" + "I6\n" + " \n" + " \n" + "I5\n" + " \n" + " \n" + "I4\n" + " \n" + " \n" + "I3\n" + " \n" + " \n" + "I2\n" + " \n" + " \n" + "I1\n" +
            " \n" + " \n" + "J10\n" +" \n" + " \n" + "J9\n" + " \n" + " \n" + "J8\n" + " \n" + " \n" + "J7\n" + " \n" + " \n" + "J6\n" + " \n" + " \n" + "J5\n" + " \n" + " \n" + "J4\n" + " \n" + " \n" + "J3\n" + " \n" + " \n" + "J2\n" + " \n" + " \n" + "J1"
    ;

    @Test
    void givenAllCoordinates_whenRun_thenEndGame() {
        setInput(allMovesTwice);
        SeaBattle sb = new SeaBattle();
        sb.run();
        getOutput();
        printOut();
        assertTrue(getOutputLines()[getOutputLines().length - 1].contains("won the game!"));
    }
}
