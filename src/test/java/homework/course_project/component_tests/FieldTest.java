package homework.course_project.component_tests;

import course_project.components.Coordinates;
import course_project.components.Field;
import course_project.components.Ship;
import course_project.enums.ShipType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldTest {
    final Field field = new Field();


    @Test
    void givenFieldCreated_whenCheckCells_thenItIsEmpty(){
        for (int[] row: field.getField()
             ) {
            for (int i: row
                 ) {
                assertEquals(0, i);
            }
        }
    }
    @Test
    void givenShipPlaced_whenCheckCells_thenContainsDecks(){
        List<Coordinates> shipCoords = new ArrayList<>();
        shipCoords.add(new Coordinates(1,1));
        shipCoords.add(new Coordinates(1,2));
        shipCoords.add(new Coordinates(1,3));
        shipCoords.add(new Coordinates(1,4));
        Ship ship = new Ship(1, ShipType.AIR_CARRIER, 4, shipCoords);

        field.placeShip(ship);
        int countDecks = 0;
        for (int[] row: field.getField()
        ) {
            for (int i: row
            ) {
                if (i == '#'){
                    countDecks++;
                }
            }
        }
        assertEquals(4, countDecks);
    }

    @Test
    void givenHitPlaced_whenCheckCells_thenContainsDecks(){
        Coordinates hitCoordinates1 = new Coordinates(2,3);
        Coordinates hitCoordinates2 = new Coordinates(1,3);
        Coordinates hitCoordinates3 = new Coordinates(5,3);
        Coordinates hitCoordinates4 = new Coordinates(2,5);

        field.placeHit(hitCoordinates1);
        field.placeHit(hitCoordinates2);
        field.placeHit(hitCoordinates3);
        field.placeHit(hitCoordinates4);

        int countHits = 0;
        for (int[] row: field.getField()
        ) {
            for (int i: row
            ) {
                if (i == 'X'){
                    countHits++;
                }
            }
        }
        assertEquals(4, countHits);
    }
    @Test
    void givenMissPlaced_whenCheckCells_thenContainsDecks(){
        Coordinates missCoordinates1 = new Coordinates(2,3);
        Coordinates missCoordinates2 = new Coordinates(1,3);
        Coordinates missCoordinates3 = new Coordinates(5,3);
        Coordinates missCoordinates4 = new Coordinates(2,5);

        field.placeMiss(missCoordinates1);
        field.placeMiss(missCoordinates2);
        field.placeMiss(missCoordinates3);
        field.placeMiss(missCoordinates4);

        int countMisses = 0;
        for (int[] row: field.getField()
        ) {
            for (int i: row
            ) {
                if (i == '*'){
                    countMisses++;
                }
            }
        }
        assertEquals(4, countMisses);
    }

}






