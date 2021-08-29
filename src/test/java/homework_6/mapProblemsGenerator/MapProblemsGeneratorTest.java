package homework_6.mapProblemsGenerator;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapProblemsGeneratorTest extends UnitBase {

    @Test
    void given2cats_whenRunCatIssue_thenHashcodeCollision(){
        new MapProblemsGenerator().runCatIssue();
        assertEquals("cat1.equals(cat2): false", getOutputLines()[0]);
        assertEquals("cat1.hashCode() == cat2.hashCode(): true", getOutputLines()[1]);
    }

    @Test
    void givenMutableDog_whenRunDogIssue_thenLooseDog(){
        new MapProblemsGenerator().runDogIssue();
        assertEquals("map.containsKey(dog) = true", getOutputLines()[0]);
        assertEquals("dog grows...", getOutputLines()[1]);
        assertEquals("map.containsKey(dog) = false", getOutputLines()[2]);
    }

}