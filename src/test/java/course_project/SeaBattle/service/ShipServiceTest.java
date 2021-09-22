package course_project.SeaBattle.service;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.model.Ship;
import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.model.ShipType;
import course_project.SeaBattle.model.SquareType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShipServiceTest {

    @Test
    void givenPlayerAndFireShipSquare_WheProcessFire_thenReduceShipHeal() {

        Player player = new Player();
        player.setName("p1");
        Player player2 = new Player();
        player2.setName("p2");
        player.setEnemy(player2);
        player2.setEnemy(player);
        ArrayList <Ship> ships = new ArrayList<>();
        ArrayList<Square> squareShipList = new ArrayList<>();

        GridService.createGrid(player);

        squareShipList.add(new Square(3,3, SquareType.SHIP));
        squareShipList.add(new Square(3,4, SquareType.SHIP));
        squareShipList.add(new Square(3,5, SquareType.SHIP));
        squareShipList.add(new Square(3,6, SquareType.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);

        ships.add(ship);
        player.setShipList(ships);
        Square fireSquare34 = new Square(3,4, SquareType.OCEAN);
        Square fireSquare35 = new Square(3,5, SquareType.OCEAN);

        ShipService.processFire(player, fireSquare34);
        assertEquals(3, player.getShipList().get(0).getShipHeal());

        ShipService.processFire(player, fireSquare35);
        assertEquals(2, player.getShipList().get(0).getShipHeal());
    }

    @Test
    void givenPlayerAndFireMissSquare_WhenProcessFire_thenDoNotChangeShipHeal() {

        Player player = new Player();
        player.setEnemy(new Player());
        ArrayList <Ship> ships = new ArrayList<>();
        ArrayList<Square> squareShipList = new ArrayList<>();

        GridService.createGrid(player);

        squareShipList.add(new Square(3,3, SquareType.SHIP));
        squareShipList.add(new Square(3,4, SquareType.SHIP));
        squareShipList.add(new Square(3,5, SquareType.SHIP));
        squareShipList.add(new Square(3,6, SquareType.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);

        ships.add(ship);
        player.setShipList(ships);

        Square fireSquare34 = new Square(4,4, SquareType.OCEAN);

        ShipService.processFire(player, fireSquare34);
        assertEquals(4, player.getShipList().get(0).getShipHeal());

        Square fireSquare35 = new Square(2,5, SquareType.OCEAN);
        ShipService.processFire(player, fireSquare35);
        assertEquals(4, player.getShipList().get(0).getShipHeal());
    }

    @Test
    void givenAcceptableShip_WhenArrangeShipOnGrid_thenReturnTrue() {

        Player player = new Player();
        player.setEnemy(new Player());
        ArrayList <Ship> ships = new ArrayList<>();

        GridService.createGrid(player);

        ArrayList<Square> squareShipList = new ArrayList<>();
        squareShipList.add(new Square(3,3, SquareType.SHIP));
        squareShipList.add(new Square(3,4, SquareType.SHIP));
        squareShipList.add(new Square(3,5, SquareType.SHIP));
        squareShipList.add(new Square(3,6, SquareType.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);
        ShipService.setShipSquares(ship, 1);
        ships.add(ship);
        player.setShipList(ships);

        Square initialSquare = new Square(6,7, SquareType.SHIP);
        Ship newShip = new Ship(new ArrayList<>(), ShipType.CRUISER);

        assertTrue(ShipService.canArrangeShipOnGrid(ships, newShip, initialSquare, 1));

    }

    @Test
    void givenNonAcceptableShip_WhenArrangeShipOnGrid_thenReturnFalse() {

        Player player = new Player();
        player.setEnemy(new Player());
        ArrayList <Ship> ships = new ArrayList<>();

        GridService.createGrid(player);

        ArrayList<Square> squareShipList = new ArrayList<>();
        squareShipList.add(new Square(3,3, SquareType.SHIP));
        squareShipList.add(new Square(3,4, SquareType.SHIP));
        squareShipList.add(new Square(3,5, SquareType.SHIP));
        squareShipList.add(new Square(3,6, SquareType.SHIP));
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);
        ShipService.setShipSquares(ship, 1);
        ships.add(ship);
        player.setShipList(ships);

        Square initialSquare = new Square(4,4, SquareType.SHIP); // too close
        Ship newShip = new Ship(new ArrayList<>(), ShipType.CRUISER);

        assertFalse(ShipService.canArrangeShipOnGrid(ships, newShip, initialSquare, 1));
    }

    @Test
    void givenShip_WhenSetShipSquares_thenHaveBoardSquares() {

        ArrayList<Square> squareShipList = new ArrayList<>();
        Square initialSquare = new Square(3,3, SquareType.SHIP);
        squareShipList.add(initialSquare);
        Ship ship = new Ship(squareShipList, ShipType.BATTLESHIP);

        ShipService.setShipSquares(ship, 1);

        assertTrue(ship.getShipSquares().contains(new Square(3,4, SquareType.SHIP)));
        assertTrue(ship.getShipSquares().contains(new Square(3,6, SquareType.SHIP)));
        assertTrue(ship.getBoundedSquare().contains(new Square(2,2, SquareType.BOARD)));
        assertTrue(ship.getBoundedSquare().contains(new Square(2,7, SquareType.BOARD)));
        assertTrue(ship.getBoundedSquare().contains(new Square(4,2, SquareType.BOARD)));
        assertTrue(ship.getBoundedSquare().contains(new Square(4,7, SquareType.BOARD)));
    }
}