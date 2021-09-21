package course_project.utils;

public class RandomShipDirectionGenerator {

    private RandomShipDirectionGenerator() {}

    public static boolean generateRandomDirection() {
        return Math.random() <= 0.5;
    }

}
