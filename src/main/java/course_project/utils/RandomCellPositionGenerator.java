package course_project.utils;

import java.security.SecureRandom;

import static course_project.gamestuff.field.Field.FIELD_SIZE;

public class RandomCellPositionGenerator {

    private RandomCellPositionGenerator() {}

    public static int generateRandomForCell() {
        return new SecureRandom().nextInt(FIELD_SIZE);
    }

}
