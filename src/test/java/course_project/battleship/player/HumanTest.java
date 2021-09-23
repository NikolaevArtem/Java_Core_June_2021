package course_project.battleship.player;

import course_project.battleship.model.Ship;
import course_project.battleship.utils.Coordinate;
import course_project.battleship.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HumanTest {

    @Test
    void testPlaceShipMethod() {
        Human human = new Human("Test");
        Coordinate coordinate = new Coordinate(5, 5);
        int direction = 2;
        Ship ship = new Ship(4);
        human.placeShip(coordinate, ship, direction);
        assertNotNull(human.getBattlefield().getField()[coordinate.getX()][coordinate.getY()].getShip());
    }

    @Test
    void testMakeTurnMethod() {
        Human human = new Human("Test");
        Coordinate coordinate = new Coordinate(5, 5);
        Human enemy = new Human("enemy");
        int direction = 2;
        Ship ship = new Ship(4);
        enemy.placeShip(coordinate, ship, direction);
        human.makeTurn(enemy, coordinate);
        assertEquals(Position.State.HIT, human.getMonitorField()
                .getField()[coordinate.getX()][coordinate.getY()].getState());
        assertEquals(Position.State.HIT, enemy.getBattlefield()
                .getField()[coordinate.getX()][coordinate.getY()].getState());
    }
}