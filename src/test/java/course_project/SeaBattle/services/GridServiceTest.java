package course_project.SeaBattle.services;

import course_project.SeaBattle.models.Grid;
import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.models.Ship;
import course_project.SeaBattle.models.Square;
import course_project.SeaBattle.utility.ShipType;
import course_project.SeaBattle.utility.SquareStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridServiceTest {

    @Test
    void givenPlayer_whenRun_thenPlayerHaveOceanGrid() {

        Player player = new Player();
        Square oceanSquare = new Square(0, 0, SquareStatus.OCEAN);

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
        squareShipList.add(new Square(3,3,SquareStatus.SHIP));
        squareShipList.add(new Square(3,4,SquareStatus.SHIP));
        squareShipList.add(new Square(3,5,SquareStatus.SHIP));
        squareShipList.add(new Square(3,6,SquareStatus.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);

        ArrayList <Ship> ships = new ArrayList<>();
        ships.add(ship);

        GridService.addShipsToGrid(player.getGrid(), ships);

        assertEquals(SquareStatus.SHIP, player.getGrid().getSquare(3, 3).getSquareStatus());
        assertEquals(SquareStatus.SHIP, player.getGrid().getSquare(3, 4).getSquareStatus());
        assertEquals(SquareStatus.SHIP, player.getGrid().getSquare(3, 5).getSquareStatus());
        assertEquals(SquareStatus.SHIP, player.getGrid().getSquare(3, 6).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player.getGrid().getSquare(4, 3).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player.getGrid().getSquare(2, 5).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player.getGrid().getSquare(4, 6).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player.getGrid().getSquare(3, 7).getSquareStatus());
    }

}