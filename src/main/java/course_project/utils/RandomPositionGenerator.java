package course_project.utils;

import java.util.Random;

public class RandomPositionGenerator {

    public static int generateRandomForCell() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
