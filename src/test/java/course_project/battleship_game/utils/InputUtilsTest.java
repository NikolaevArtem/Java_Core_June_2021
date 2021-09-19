package course_project.battleship_game.utils;

import base.UnitBase;
import course_project.battleship_game.model.GameMode;
import org.junit.jupiter.api.Test;

import static course_project.battleship_game.utils.Constants.CHOOSE_GAME_MODE_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_SHIP_DIRECTION_MESSAGE;
import static course_project.battleship_game.utils.Constants.DEFAULT_PLAYER_NAME;
import static course_project.battleship_game.utils.Constants.ERROR_INPUT_MESSAGE;
import static course_project.battleship_game.utils.Constants.GET_PLAYER_NAME_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class InputUtilsTest extends UnitBase {

    @Test
    void testGetNameString() {
        setInput("Hero");
        String playerName = InputUtils.getPlayerName();
        assertEquals("Hero", playerName);
        assertTrue(getOutput().contains(GET_PLAYER_NAME_MESSAGE.trim()));
    }

    @Test
    void testGetNameStringNumber() {
        setInput("11");
        String playerName = InputUtils.getPlayerName();
        assertEquals("11", playerName);
        assertTrue(getOutput().contains(GET_PLAYER_NAME_MESSAGE.trim()));
    }

    @Test
    void testGetNameEmptyString() {
        setInput("");
        String playerName = InputUtils.getPlayerName();
        assertEquals(DEFAULT_PLAYER_NAME, playerName);
        assertTrue(getOutput().contains(GET_PLAYER_NAME_MESSAGE.trim()));
    }

    @Test
    void testGetDirectionZero() {
        setInput("2\nString\n0");
        assertEquals(0, InputUtils.getDirection());
        assertTrue(getOutput().contains(ERROR_INPUT_MESSAGE));
        assertTrue(getOutput().contains(CHOOSE_SHIP_DIRECTION_MESSAGE.trim()));
    }

    @Test
    void testGetDirectionOne() {
        setInput("1");
        assertEquals(1, InputUtils.getDirection());
        assertTrue(getOutput().contains(CHOOSE_SHIP_DIRECTION_MESSAGE.trim()));
    }

    @Test
    void testGetModeToCreateFleetZero() {
        setInput("2\nString\n0");
        assertEquals(0, InputUtils.getModeToCreateFleet());
        assertTrue(getOutput().contains(ERROR_INPUT_MESSAGE.trim()));
        assertTrue(getOutput().contains(CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE.trim()));
    }

    @Test
    void testGetModeToCreateFleetOne() {
        setInput("1");
        assertEquals(1, InputUtils.getModeToCreateFleet());
        assertTrue(getOutput().contains(CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE.trim()));
    }

    @Test
    void testGetGameModeCVC() {
        setInput("0");
        assertEquals(GameMode.CVC, InputUtils.getGameMode());
        assertTrue(getOutput().contains(CHOOSE_GAME_MODE_MESSAGE.trim()));
    }

    @Test
    void testGetGameModePVC() {
        setInput("1");
        assertEquals(GameMode.PVC, InputUtils.getGameMode());
        assertTrue(getOutput().contains(CHOOSE_GAME_MODE_MESSAGE.trim()));
    }

    @Test
    void testGetGameModePVP() {
        setInput("s\n5\n2");
        assertEquals(GameMode.PVP, InputUtils.getGameMode());
        assertTrue(getOutput().contains(CHOOSE_GAME_MODE_MESSAGE.trim()));
    }

}
