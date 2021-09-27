package homework.course_project.component_tests;

import course_project.components.Coordinates;
import course_project.components.Ship;
import course_project.enums.ShipType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShipTest {


    @Test
    void givenNewShip_whenCreate_thenItIsExist(){
        List<Coordinates> shipCoords = new ArrayList<>();
        shipCoords.add(new Coordinates(1,1));
        shipCoords.add(new Coordinates(1,2));
        shipCoords.add(new Coordinates(1,3));
        shipCoords.add(new Coordinates(1,4));
        Ship ship = new Ship(1, ShipType.AIR_CARRIER, 4, shipCoords);

        assertNotNull(ship);
    }

    @Test
    void whenShipGetEnoughShots_thenItDies(){
        List<Coordinates> shipCoords = new ArrayList<>();
        shipCoords.add(new Coordinates(1,1));
        shipCoords.add(new Coordinates(1,2));
        shipCoords.add(new Coordinates(1,3));

        Ship ship = new Ship(1, ShipType.CRUISER, 3, shipCoords);
        ship.gotShot();
        ship.gotShot();
        ship.gotShot();
        System.out.println(ship.isAlive());
        assertFalse(ship.isAlive());
    }




}
