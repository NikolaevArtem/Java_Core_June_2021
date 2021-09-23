package SeaBattle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static SeaBattle.GenerateShips.FIELD_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenerateShipsTest {


    @Test
    void testCreateShipWith1Size() {
        int[][] arr = new int[FIELD_SIZE][FIELD_SIZE];

        GenerateShips generateShips = new GenerateShips();
        generateShips.fillField(arr, 1);
        System.out.println(Arrays.deepToString(arr));
        assertEquals(1, (int) Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(x -> x == 1).count());
        assertTrue(Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(x -> x == 9).count() >= 3);
    }

    @Test
    void testCreateShipWith4Size() {
        int[][] arr = new int[FIELD_SIZE][FIELD_SIZE];
        GenerateShips generateShips = new GenerateShips();
        generateShips.fillField(arr, 4);
        assertEquals(4, (int) Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(x -> x == 4).count());
        assertTrue(Arrays.stream(arr).flatMapToInt(Arrays::stream).filter(x -> x == 9).count() >= 6);
    }

    @Test
    void testCreateBoardWithAllShips() {
        GenerateShips generateShips = new GenerateShips();
        char[][] arr = generateShips.createBoardWithShips();
        assertEquals(20, (int) Arrays.stream(arr)
                .flatMap((item) -> new String(item).chars().mapToObj(a -> (char) a))
                .filter(x -> x == '0').count());
    }

}
