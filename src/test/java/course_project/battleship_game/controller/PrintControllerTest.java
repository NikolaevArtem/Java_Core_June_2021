package course_project.battleship_game.controller;

import base.UnitBase;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.service.PlayerService;
import org.junit.jupiter.api.Test;

import static course_project.battleship_game.utils.Constants.PLAYER_BOARD_MESSAGE_FORMAT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrintControllerTest extends UnitBase {

    @Test
    void testPrintBoards() {
        GameMode mode = GameMode.CVC;
        Player hero = new Player("Hero", 0);
        Player villain = new Player("Villain", 0);
        PlayerService serviceHero = new PlayerService(hero);
        PlayerService serviceVillain = new PlayerService(villain);
        serviceHero.createFleetForPlayer();
        serviceVillain.createFleetForPlayer();
        new PrintController().printBoards(mode, hero, villain);
        printOut();
        assertTrue(getOutput().contains(String.format(PLAYER_BOARD_MESSAGE_FORMAT, hero.getName())));
        assertTrue(getOutput().contains(String.format(PLAYER_BOARD_MESSAGE_FORMAT, villain.getName())));
    }

    @Test
    void printBoardForPlayerHero() {
        Player hero = new Player("Hero", 0);
        PlayerService service = new PlayerService(hero);
        service.createFleetForPlayer();
        new PrintController().printBoardForPlayer(hero, false);
        printOut();
        assertEquals(10, hero.getBoard().getShipList().size());
        assertTrue(getOutput().contains(String.format(PLAYER_BOARD_MESSAGE_FORMAT.trim(), hero.getName())));
    }

    @Test
    void printBoardForPlayerEnemy() {
        Player enemy = new Player("Villain", 0);
        PlayerService service = new PlayerService(enemy);
        service.createFleetForPlayer();
        new PrintController().printBoardForPlayer(enemy, true);
        printOut();
        assertEquals(10, enemy.getBoard().getShipList().size());
        assertTrue(getOutput().contains(String.format(PLAYER_BOARD_MESSAGE_FORMAT.trim(), enemy.getName())));
    }
}