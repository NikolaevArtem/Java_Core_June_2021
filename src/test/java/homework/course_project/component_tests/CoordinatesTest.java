package homework.course_project.component_tests;
import course_project.components.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {


        @Test
        void givenTwoInts_whenCreateCoordinates_thenCreated(){
            int x = 1;
            int y = 1;

            Coordinates coordinates = new Coordinates(x,y);
            assertNotNull(coordinates);
        }

        @Test
        void givenTwoDifferentCoordinates_whenCompare_thenNotSame(){
            int x1 = 1;
            int y1 = 1;
            int x2 = 2;
            int y2 = 2;

            Coordinates coordinatesFirst = new Coordinates(x1,y2);
            Coordinates coordinatesSecond = new Coordinates(x2, y2);

            assertNotSame(coordinatesFirst, coordinatesSecond);
        }

        @Test
        void givenTwoSameCoordinates_whenCompare_thenSame(){
           int x1 = 1;
           int y1 = 1;
           int x2 = 1;
           int y2 = 1;

            Coordinates coordinatesFirst = new Coordinates(x1,y2);
            Coordinates coordinatesSecond = new Coordinates(x2, y2);

            assertEquals(coordinatesFirst, coordinatesSecond);
    }
}
