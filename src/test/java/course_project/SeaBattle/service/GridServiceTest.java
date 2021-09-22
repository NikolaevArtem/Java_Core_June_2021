package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.model.ShipType;
import course_project.SeaBattle.model.SquareType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridServiceTest {

    @Test
    void givenPlayer_whenRun_thenPlayerHaveOceanGrid() {

        Player player = new Player();
        Square oceanSquare = new Square(0, 0, SquareType.OCEAN);

        GridService.createGrid(player);

        assertNotNull(player.getGrid());
        assertEquals(oceanSquare.getSquareStatus(), player.getGrid().getSquare(0, 0).getSquareStatus());
        assertEquals(oceanSquare.getSquareStatus(), player.getGrid().getSquare(5, 5).getSquareStatus());
        assertEquals(oceanSquare.getSquareStatus(), player.getGrid().getSquare(9, 9).getSquareStatus());
    }

    @Test
    void givenPlayerAndShip_whenRun_thenPlayerHaveGridWithShip() {

        Player player = new Player();
        GridService.createGrid(player);

        ArrayList <Square> squareShipList = new ArrayList<>();
        squareShipList.add(new Square(3,3, SquareType.SHIP));
        squareShipList.add(new Square(3,4, SquareType.SHIP));
        squareShipList.add(new Square(3,5, SquareType.SHIP));
        squareShipList.add(new Square(3,6, SquareType.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);

        ArrayList <Ship> ships = new ArrayList<>();
        ships.add(ship);

        GridService.addShipsToGrid(player.getGrid(), ships);

        assertEquals(SquareType.SHIP, player.getGrid().getSquare(3, 3).getSquareStatus());
        assertEquals(SquareType.SHIP, player.getGrid().getSquare(3, 4).getSquareStatus());
        assertEquals(SquareType.SHIP, player.getGrid().getSquare(3, 5).getSquareStatus());
        assertEquals(SquareType.SHIP, player.getGrid().getSquare(3, 6).getSquareStatus());
        assertEquals(SquareType.OCEAN, player.getGrid().getSquare(4, 3).getSquareStatus());
        assertEquals(SquareType.OCEAN, player.getGrid().getSquare(2, 5).getSquareStatus());
        assertEquals(SquareType.OCEAN, player.getGrid().getSquare(4, 6).getSquareStatus());
        assertEquals(SquareType.OCEAN, player.getGrid().getSquare(3, 7).getSquareStatus());
    }

}