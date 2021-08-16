package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest extends UnitBase {
    HelloGenerator helloGenerator = new HelloGenerator();
    HelloGenerator helloGenerator1 = new HelloGenerator(null, 5);

    @Test
    void givenEmptyNameField_whenCreateObject_thenTakeFromAnnotation(){
        String expected = "Egor";
        assertEquals(expected, helloGenerator.getName());
    }

    @Test
    void givenEmptyAgeField_whenCreateObject_thenTakeFromAnnotation(){
        int expected = 15;
        assertEquals(expected, helloGenerator.getAge());
    }

    @Test
    void run3(){
        String expected = "Egor";
        assertEquals(expected, helloGenerator1.getName());
    }

    @Test
    void run4(){
        int expected = 5;
        assertEquals(expected, helloGenerator1.getAge());
    }
}
