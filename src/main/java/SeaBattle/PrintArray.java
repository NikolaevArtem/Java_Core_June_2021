package SeaBattle;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static SeaBattle.StartGame.currentCountOfShots;

interface PrintArray {

    static void printBoard(char[][] map) {
        AtomicInteger i = new AtomicInteger(1);
        System.out.println("Current board: x - miss,  X - HIT!, Current Round = " + currentCountOfShots + "\n   A B C D E F G H I J ");
        Arrays.stream(map)
                .forEach(m -> System.out.println( i.getAndIncrement() + " " + Arrays.toString(m).replace(",", "").replace("0", "_")));
    }
}
