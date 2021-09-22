package course_project;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameplayTest extends UnitBase {

    @Test
    void givenPlayersShots_whenGamePlay_thenPrintUserWon() {
        setInput("B-2\n" +
                "B-3\n" +
                "B-4\n" +
                "B-5\n" +
                "B-6\n" +
                "D-2\n" +
                "D-3\n" +
                "D-4\n" +
                "D-5\n" +
                "F-2\n" +
                "F-3\n" +
                "F-4\n" +
                "B-8\n" +
                "B-9\n" +
                "B-10\n" +
                "J-4\n" +
                "J-3\n" +
                "B-2\n" +
                "B-3\n" +
                "B-4\n" +
                "B-5\n" +
                "B-6\n" +
                "D-2\n" +
                "D-3\n" +
                "D-4\n" +
                "D-5\n" +
                "F-2\n" +
                "F-3\n" +
                "F-4\n" +
                "B-8\n" +
                "B-9\n" +
                "B-10\n" +
                "J-4\n" +
                "J-3\n" +
                "B-2\n" +
                "B-3\n" +
                "B-4\n" +
                "B-5\n" +
                "B-6\n" +
                "D-2\n" +
                "D-3\n" +
                "D-4\n" +
                "D-5\n" +
                "F-2\n" +
                "F-3\n" +
                "F-4\n" +
                "B-8\n" +
                "B-9\n" +
                "B-10\n" +
                "J-4\n" +
                "J-3\n" +
                "B-2\n" +
                "B-3\n" +
                "B-4\n" +
                "B-5\n" +
                "B-6\n" +
                "D-2\n" +
                "D-3\n" +
                "D-4\n" +
                "D-5\n" +
                "F-2\n" +
                "F-3\n" +
                "F-4\n" +
                "B-8\n" +
                "B-9\n" +
                "B-10\n" +
                "J-4\n" +
                "J-3");

        new GameLauncher().launch();

        assertEquals("      YOU WIN!", getOutputLines()[getOutputLines().length - 2]);
    }
}
