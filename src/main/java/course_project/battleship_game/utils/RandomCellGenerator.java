package course_project.battleship_game.utils;

import course_project.battleship_game.model.Cell;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCellGenerator {

    public static Cell generateRandomCell() {
        int x = ThreadLocalRandom.current().nextInt(0, 10);
        int y = ThreadLocalRandom.current().nextInt(0, 10);
        return new Cell(x, y);
    }
}
