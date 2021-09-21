package course_project.sea_battle;

import base.UnitBase;
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

class GameTest extends UnitBase {

    private static final String INPUTSHIPERROR = "Input should be like this: [A7 h] or [B2 h]. Try again!";
    private static final String OUTOFBOARD = "Impossible to place ship here because it is out of board!";
    private static final String TIE = "Game over. It's a TIE!";
    private static final String GAMEOVER = "Game over. The winner is: ";

    @Test
    void testNameSetter() {
        String input = "Tom\n" +
                "Vera\n" +
                "\n";
        setInput(input);

        Game game = new Game();
        game.setUpNames();

        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();

        assertEquals("Tom", player1.getName());
        assertEquals("Vera", player2.getName());
    }

    @Test
    void testValidCoordsShipPlacing() {
        String input = "a1 h\n" +
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

        Game game = new Game();
        game.setUpShips();

        long numOfShips1 = game.getPlayer1().countShips();
        long numOfShips2 = game.getPlayer2().countShips();

        assertEquals(10, numOfShips1);
        assertEquals(10, numOfShips2);
    }

    @Test
    void testOnlyValidCoordsShipPlacing() {
        String input = "a1 h\n" +
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

        Game game = new Game();
        game.setUpShips();

        long numOfShips1 = game.getPlayer1().countShips();
        long numOfShips2 = game.getPlayer2().countShips();

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

        assertTrue(inputShipReader.isShipWithinBoard(3));
        assertFalse(inputShipReader.isShipWithinBoard(4));
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

        Game game = new Game();
        game.getPlayer1().getMyShips().add(ship);
        game.getPlayer2().getMyShips().add(ship2);

        game.getPlayer1().getMyBoard().placeShip(ship);
        game.getPlayer2().getMyBoard().placeShip(ship2);

        int numOfPlayer1AllShips = game.getPlayer1().getMyShips().size();
        int numOfPlayer2AllShips = game.getPlayer1().getMyShips().size();

        assertEquals(1, numOfPlayer1AllShips);
        assertEquals(1, numOfPlayer2AllShips);

        game.startGame();

        long numOfPlayer1AliveShips = game.getPlayer1().getMyShips().stream()
                .filter(Ship::isAlive)
                .count();
        long numOfPlayer2AliveShips = game.getPlayer2().getMyShips().stream()
                .filter(Ship::isAlive)
                .count();

        assertEquals(1, numOfPlayer1AliveShips);
        assertEquals(0, numOfPlayer2AliveShips);
    }

    @Test
    void testDefineWinner() {
        Game game = new Game();
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        player1.setName("Tom");
        player2.setName("Vera");

        Ship ship = new Ship(Arrays.asList(new Point(1, 1)));
        List<Ship> tomShips = game.getPlayer1().getMyShips();
        tomShips.add(ship);

        game.defineWinner();

        assertEquals(GAMEOVER + "Tom!", getOutput());
        removeFromOutput(GAMEOVER + "Tom!");

        List<Ship> veraShips = game.getPlayer2().getMyShips();
        veraShips.add(ship);
        tomShips.remove(0);

        game.defineWinner();
        assertEquals(GAMEOVER + "Vera!", getOutput());
        removeFromOutput(GAMEOVER + "Vera!");

        veraShips.remove(0);
        game.defineWinner();
        assertEquals(TIE, getOutput());
    }

}