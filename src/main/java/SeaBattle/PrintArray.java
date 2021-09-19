package SeaBattle;

import java.util.Arrays;

import static SeaBattle.StartGame.currentCountOfShots;

interface PrintArray {

    static void printBoard(char[][] map) {
        System.out.println("Current board: x - miss,  X - HIT!, Current Round = " + currentCountOfShots);
        Arrays.stream(map)
                .forEach(m -> System.out.println(Arrays.toString(m).replace(",", "").replace("0", "_")));
    }
}
