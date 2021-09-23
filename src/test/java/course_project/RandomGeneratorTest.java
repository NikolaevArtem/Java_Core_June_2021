package course_project;

import course_project.sea_battle.utils.RandomGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGeneratorTest {

    @Test
    void whenGenerateInRange_thenCorrect() {
        int random = RandomGenerator.getRandomInRange(4, 7);

        assertTrue(random >= 4 && random <= 7);

    }
}
