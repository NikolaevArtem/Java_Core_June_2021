package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

public class ChairConstructorAnnotationTest extends UnitBase {

    private final InfoProcessor infoProcessor = new InfoProcessor();

    @Test
    void givenAnnotationParameters_whenCreateNewClass_thenSomeFieldsAreDifferent() {

        class CheapChair extends Chair { }

        @ChairConstructorAnnotation(hasBack = true, dayOfProducing = DayOfWeek.TUESDAY)
        class ChairWithBack extends Chair { }

        final Chair cheap = new CheapChair();
        final Chair withBack = new ChairWithBack();
        infoProcessor.printInfo(cheap);
        infoProcessor.printInfo(withBack);
        getOutput();

        assertEquals("legs = 4", getOutputLines()[0].trim());
        assertEquals("hasBack = false", getOutputLines()[1].trim());
        assertEquals("shape = square", getOutputLines()[2].trim());
        assertEquals("materials = {wood}", getOutputLines()[3].trim());
        assertEquals("dayOfProducing = MONDAY", getOutputLines()[4].trim());

        assertEquals("legs = 4", getOutputLines()[5].trim());
        assertEquals("hasBack = true", getOutputLines()[6].trim());
        assertEquals("shape = square", getOutputLines()[7].trim());
        assertEquals("materials = {wood}", getOutputLines()[8].trim());
        assertEquals("dayOfProducing = TUESDAY", getOutputLines()[9].trim());
    }

    @Test
    void givenAnnotationParameters_whenCreateClassAndExtendThisClass_thenFieldsAreInherited() {

        @ChairConstructorAnnotation(shape = "circle",
                materials = {"wood", "cotton", "pad", "plastic"},
                hasBack = true,
                dayOfProducing = DayOfWeek.THURSDAY)
        class SoftChair extends Chair { }

        class AnotherSoftChair extends SoftChair {
        }

        final Chair softChair = new SoftChair();
        final Chair anotherChair = new AnotherSoftChair();
        infoProcessor.printInfo(softChair);
        infoProcessor.printInfo(anotherChair);
        getOutput();

        assertEquals("legs = 4", getOutputLines()[0].trim());
        assertEquals("hasBack = true", getOutputLines()[1].trim());
        assertEquals("shape = circle", getOutputLines()[2].trim());
        assertEquals("materials = {wood, cotton, pad, plastic}", getOutputLines()[3].trim());
        assertEquals("dayOfProducing = THURSDAY", getOutputLines()[4].trim());

        assertEquals("legs = 4", getOutputLines()[5].trim());
        assertEquals("hasBack = true", getOutputLines()[6].trim());
        assertEquals("shape = circle", getOutputLines()[7].trim());
        assertEquals("materials = {wood, cotton, pad, plastic}", getOutputLines()[8].trim());
        assertEquals("dayOfProducing = THURSDAY", getOutputLines()[9].trim());
    }

    @Test
    void givenOneAnnotationParameterForExtendingClass_whenCreateClass_thenRestFieldAreDefault() {

        @ChairConstructorAnnotation(shape = "circle",
                legs = 3,
                materials = {"steel", "cotton", "pad", "plastic"},
                hasBack = true,
                dayOfProducing = DayOfWeek.THURSDAY)
        class SoftChair extends Chair { }

        @ChairConstructorAnnotation(dayOfProducing = DayOfWeek.FRIDAY)
        class AnotherSoftChair extends SoftChair {
        }

        final Chair softChair = new SoftChair();
        final Chair anotherChair = new AnotherSoftChair();
        infoProcessor.printInfo(softChair);
        infoProcessor.printInfo(anotherChair);
        getOutput();

        assertEquals("legs = 3", getOutputLines()[0].trim());
        assertEquals("hasBack = true", getOutputLines()[1].trim());
        assertEquals("shape = circle", getOutputLines()[2].trim());
        assertEquals("materials = {steel, cotton, pad, plastic}", getOutputLines()[3].trim());
        assertEquals("dayOfProducing = THURSDAY", getOutputLines()[4].trim());

        assertEquals("legs = 4", getOutputLines()[5].trim());
        assertEquals("hasBack = false", getOutputLines()[6].trim());
        assertEquals("shape = square", getOutputLines()[7].trim());
        assertEquals("materials = {wood}", getOutputLines()[8].trim());
        assertEquals("dayOfProducing = FRIDAY", getOutputLines()[9].trim());
    }

    @Test
    void givenNonChairClass_whenPrintInfo_thenPrintRightFields() {

        class Cat {

            @Info
            public final int age;
            @Info
            public final String name;
            public String favoriteFood = "Sour cream";
            @Info
            public String[] toys; //won't be printed cause is null
            public boolean isFat;
            @Info
            public String breed = "Unknown";


            public Cat(int age, String name) {
                this.age = age;
                this.name = name;
            }
        }

        Cat cat = new Cat(6, "Russian Cat Shlyopa");
        infoProcessor.printInfo(cat);
        getOutput();

        assertEquals("age = 6", getOutputLines()[0].trim());
        assertEquals("name = Russian Cat Shlyopa", getOutputLines()[1].trim());
        assertEquals("breed = Unknown", getOutputLines()[2].trim());
        assertEquals(3, getOutputLines().length);
    }
}
