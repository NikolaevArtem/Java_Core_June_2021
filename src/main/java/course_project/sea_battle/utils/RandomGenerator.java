package course_project.sea_battle.utils;

public class RandomGenerator {

    public static int getRandomInRange(int max, int min) {
        return (int) ((Math.random() * (max - min - 1)) + min + 1);
    }
}
