package course_project.SeaBattle.service;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InitialGameControllerServiceTest extends UnitBase {



    @Test
    void createGameModePVC_whenCreateGame_thenGameHavePlayers() {

        setInput("0");

        InitialGameService.createGame();
        ArrayList<?> players = null;

        try {
            Field field = InitialGameService.class.getDeclaredField("playerList");
            field.setAccessible(true);
            players = (ArrayList<?>) field.get(null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assert players != null;
        assertFalse(players.isEmpty());


    }

    @Test
    void createGameModePVP_whenCreateGame_thenGameHavePlayers() {

        setInput("1");

        InitialGameService.createGame();
        ArrayList<?> players = null;

        try {
            Field field = InitialGameService.class.getDeclaredField("playerList");
            field.setAccessible(true);
            assertNotNull(field);
            players = (ArrayList<?>) field.get(null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        assert players != null;
        assertFalse(players.isEmpty());
    }
}