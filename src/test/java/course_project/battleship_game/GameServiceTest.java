package course_project.battleship_game;

import base.UnitBase;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.service.GameService;
import course_project.battleship_game.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceTest extends UnitBase {
    private final GameService service = new GameService();

    @Test
    void testCreateUsersCVC() {
        Player[] players = service.createPlayers(GameMode.CVC);
        assertEquals(2, players.length);
        assertTrue(players[0].getName().contains("Computer"));
        assertTrue(players[1].getName().contains("Computer"));
    }

    @Test
    void testCreateUsersPVC() {
        setInput("test\n0");
        Player[] players = service.createPlayers(GameMode.PVC);
        assertEquals(2, players.length);
        assertFalse(players[0].getName().contains("Computer"));
        assertTrue(players[1].getName().contains("Computer"));
    }

    @Test
    void testCreateUsersPVP() {
        setInput("test\n0\ntest1\n0");
        Player[] players = service.createPlayers(GameMode.PVP);
        assertEquals(2, players.length);
        assertFalse(players[0].getName().contains("Computer"));
        assertFalse(players[1].getName().contains("Computer"));
    }


    @Test
    void testRollingDiceShufflePlayers() {
        Player[] players = service.createPlayers(GameMode.CVC);
        Player one = players[0];
        service.rollingDiceToChooseWhoStarts(players);
        if (getOutput().contains("1")) {
            assertEquals(one, players[0]);
        } else {
            assertNotEquals(one, players[0]);
        }

    }

    @Test
    void testCreateFleet() {
        Player[] players = service.createPlayers(GameMode.CVC);
        service.createFleet(players);
        assertEquals(10, players[0].getBoard().getShipList().size());
        assertEquals(10, players[1].getBoard().getShipList().size());
    }

    @Test
    void testIsGameOverOnStart() {
        Player[] players = service.createPlayers(GameMode.CVC);
        service.createFleet(players);
        assertFalse(service.isGameOver(players[0], players[1], GameMode.CVC));
    }

    @Test
    void testIsGameOverTrue() {
        Player[] players = service.createPlayers(GameMode.CVC);
        PlayerService playerService = new PlayerService(players[0]);
        playerService.createFleetForPlayer();
        assertTrue(service.isGameOver(players[0], players[1], GameMode.CVC));
    }

    @Test
    void testDetermineWinner() {
        Player[] players = service.createPlayers(GameMode.CVC);
        PlayerService playerService = new PlayerService(players[0]);
        playerService.createFleetForPlayer();
        service.determineWinner(players);
        assertTrue(getOutput().contains(players[0].getName()));
    }

}