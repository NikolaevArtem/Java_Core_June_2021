package course_project.sea_battle;

import base.UnitBase;
import course_project.sea_battle.controller.GameController;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.service.inputs.InputShipReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest extends UnitBase {

    private static final String INPUTSHIPERROR = "Input should be like this: [A7 h] or [B2 h]. Try again!";
    private static final String OUTOFBOARD = "Impossible to place ship here because it is out of board!";
    private static final String TIE = "Game over. It's a TIE!";
    private static final String GAMEOVER = "Game over. The winner is: ";

    @Test
    void testNameSetter() {
        String input = "1\n" +
                "Tom\n" +
                "Vera\n";
        setInput(input);

        GameController gameController = new GameController();
        gameController.setUpNames();

        Player player1 = gameController.getPlayer1();
        Player player2 = gameController.getPlayer2();

        assertEquals("Tom", player1.getName());
        assertEquals("Vera", player2.getName());
    }

    @Test
    void testValidCoordsShipPlacing() {
        String input = "1\n" +
                "a1 h\n" +
                "a3 h\n" +
                "a5 h\n" +
                "a7 h\n" +
                "a9 h\n" +
                "f1 h\n" +
                "f3 h\n" +
                "f5 h\n" +
                "f7 h\n" +
                "f9 h\n" +
                "\n" +
                "1\n" +
                "a1 h\n" +
                "a3 h\n" +
                "a5 h\n" +
                "a7 h\n" +
                "a9 h\n" +
                "f1 h\n" +
                "f3 h\n" +
                "f5 h\n" +
                "f7 h\n" +
                "f9 h\n" +
                "\n";
        setInput(input);

        GameController gameController = new GameController();
        gameController.setUpShips();

        long numOfShips1 = gameController.getPlayer1().countShips();
        long numOfShips2 = gameController.getPlayer2().countShips();

        assertEquals(10, numOfShips1);
        assertEquals(10, numOfShips2);
    }

    @Test
    void testOnlyValidCoordsShipPlacing() {
        String input = "1\n" +
                "a1 h\n" +
                "a2 h\n" +
                "a\n" +
                "a6v\n" +
                "a10 v\n" +
                "a3 h\n" +
                "a5 h\n" +
                "a7 h\n" +
                "a9 h\n" +
                "f1 h\n" +
                "f3 h\n" +
                "f5 h\n" +
                "f7 h\n" +
                "f9 h\n" +
                "\n" +
                "1\n" +
                "a1 h\n" +
                "a3 h\n" +
                "a5 h\n" +
                "a7 h\n" +
                "a9 h\n" +
                "f1 h\n" +
                "f3 h\n" +
                "f5 h\n" +
                "f7 h\n" +
                "f9 h\n" +
                "\n";
        setInput(input);

        GameController gameController = new GameController();
        gameController.setUpShips();

        long numOfShips1 = gameController.getPlayer1().countShips();
        long numOfShips2 = gameController.getPlayer2().countShips();

        assertEquals(10, numOfShips1);
        assertEquals(10, numOfShips2);
    }

    @Test
    void testComputerShipPlacing() {
        String input = "2\n" +
                "\n" +
                "2\n" +
                "\n";
        setInput(input);

        GameController gameController = new GameController();
        gameController.setUpShips();

        long numOfShips1 = gameController.getPlayer1().countShips();
        long numOfShips2 = gameController.getPlayer2().countShips();

        assertEquals(10, numOfShips1);
        assertEquals(10, numOfShips2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a6", "d1 g", "d1 v 1", ""})
    void givenInvalidShipCoords_whenSetUpShips_ThenError(String input) {
        setInput(input);
        new InputShipReader(new Scanner(System.in)).isValidInput(input);
        assertEquals(INPUTSHIPERROR, getOutput());
    }

    @Test
    void givenOutOfBoardShipCoords_whenSetUpShips_ThenError() {
        InputShipReader inputShipReader = new InputShipReader(new Scanner(System.in));
        inputShipReader.setX(7);
        inputShipReader.setY(0);
        inputShipReader.setPosition("v");

        assertTrue(inputShipReader.isShipWithinBoard(3, 1));
        assertFalse(inputShipReader.isShipWithinBoard(4, 1));
        assertEquals(OUTOFBOARD, getOutput());
    }

    @Test
    void testShooter() {
        String input = "a1\n" +
                "b1\n" +
                "\n" +
                "a10\n" +
                "\n";
        setInput(input);

        List<Point> coordinates = new ArrayList<>();
        coordinates.add(new Point(0, 0));
        coordinates.add(new Point(0, 1));
        Ship ship = new Ship(coordinates);

        List<Point> coordinates2 = new ArrayList<>();
        coordinates.add(new Point(9, 9));
        Ship ship2 = new Ship(coordinates2);

        GameController gameController = new GameController();
        gameController.getPlayer1().getMyShips().add(ship);
        gameController.getPlayer2().getMyShips().add(ship2);

        gameController.getPlayer1().getMyBoard().placeShip(ship);
        gameController.getPlayer2().getMyBoard().placeShip(ship2);

        int numOfPlayer1AllShips = gameController.getPlayer1().getMyShips().size();
        int numOfPlayer2AllShips = gameController.getPlayer1().getMyShips().size();

        assertEquals(1, numOfPlayer1AllShips);
        assertEquals(1, numOfPlayer2AllShips);

        gameController.play();

        long numOfPlayer1AliveShips = gameController.getPlayer1().getMyShips().stream()
                .filter(Ship::isAlive)
                .count();
        long numOfPlayer2AliveShips = gameController.getPlayer2().getMyShips().stream()
                .filter(Ship::isAlive)
                .count();

        assertEquals(1, numOfPlayer1AliveShips);
        assertEquals(0, numOfPlayer2AliveShips);
    }

    @Test
    void testDefineWinner() {
        GameController gameController = new GameController();
        Player player1 = gameController.getPlayer1();
        Player player2 = gameController.getPlayer2();
        player1.setName("Tom");
        player2.setName("Vera");

        Ship ship = new Ship(Arrays.asList(new Point(1, 1)));
        List<Ship> tomShips = gameController.getPlayer1().getMyShips();
        tomShips.add(ship);

        gameController.defineWinner();

        assertEquals(GAMEOVER + "Tom!", getOutput());
        removeFromOutput(GAMEOVER + "Tom!");

        List<Ship> veraShips = gameController.getPlayer2().getMyShips();
        veraShips.add(ship);
        tomShips.remove(0);

        gameController.defineWinner();
        assertEquals(GAMEOVER + "Vera!", getOutput());
        removeFromOutput(GAMEOVER + "Vera!");

        veraShips.remove(0);
        gameController.defineWinner();
        assertEquals(TIE, getOutput());
    }

}