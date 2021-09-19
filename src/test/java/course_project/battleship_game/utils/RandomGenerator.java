package course_project.battleship_game.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static int generateNumFrom0to9() {
        return ThreadLocalRandom.current().nextInt(0, 10);
    }
}
