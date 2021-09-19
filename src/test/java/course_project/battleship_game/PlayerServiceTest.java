package course_project.battleship_game;

import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.service.PlayerService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerServiceTest {

    @Test
    void testCreateRandomFleetForPlayer() {
        Player hero = new Player("Hero", 0);
        PlayerService serviceHero = new PlayerService(hero);
        serviceHero.createFleetForPlayer();
        assertEquals(10, hero.getBoard().getShipList().size());
    }

    @Test
    void testIsNoMoreAliveShipsTrue() {
        Player hero = new Player("Hero", 0);
        PlayerService serviceHero = new PlayerService(hero);
        serviceHero.createFleetForPlayer();
        hero.getBoard().getShipList().forEach(ship -> ship.getCellsList().forEach(cell -> cell.setCellStatus(CellStatus.HIT)));
        assertTrue(serviceHero.isNoMoreAliveShips());
        assertEquals(0, serviceHero.countRemainedShips());
    }

    @Test
    void testIsNoMoreAliveShipsFalse() {
        Player hero = new Player("Hero", 0);
        PlayerService serviceHero = new PlayerService(hero);
        serviceHero.createFleetForPlayer();
        assertFalse(serviceHero.isNoMoreAliveShips());
        assertEquals(10, serviceHero.countRemainedShips());
    }

}
