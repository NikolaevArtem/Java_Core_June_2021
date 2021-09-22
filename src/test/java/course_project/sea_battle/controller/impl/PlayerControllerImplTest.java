package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.PlayerController;
import course_project.sea_battle.model.BasePlayer;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.GamePlayer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PlayerControllerImplTest {
    PlayerController playerController = PlayerControllerImpl.getInstance();
    @Test
    void instance() {
        final String val1= "Тест 1";

        BasePlayer player = playerController.instance(val1);
        assertEquals(val1, player.getName());
        GamePlayer gamePlayer = null;
        if (player.getClass() == GamePlayer.class) gamePlayer = (GamePlayer) player;
        assertNotNull(gamePlayer);
        assertNotNull(gamePlayer.getFieldPlayer());
        assertNotNull(gamePlayer.getRadarPlayer());

        assertEquals(100, Arrays.stream(gamePlayer.getFieldPlayer().getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.WATER))
                .count());
        assertEquals(100, Arrays.stream(gamePlayer.getRadarPlayer().getCells())
                .flatMap(Arrays::stream)
                .filter(x -> x.equals(CellStatus.WATER))
                .count());
    }
}