package course_project.battleship_game.controller;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameControllerTest extends UnitBase {

    @Test
    void testRunCVC() {
        setInput("0");
        new GameController().run();
        printOut();
        assertTrue(getOutput().contains("won the game"));
    }
}