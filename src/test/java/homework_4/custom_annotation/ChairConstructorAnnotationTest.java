package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;

public class ChairConstructorAnnotationTest extends UnitBase {

    @Test
    void givenAnnotationParameters_whenCreateNewClass_thenFieldsAreDifferent() {

        class CheapChair extends Chair { }

        @ChairConstructorAnnotation(hasBack = true, dayOfProducing = DayOfWeek.TUESDAY)
        class ChairWithBack extends Chair { }

        Chair cheap = new CheapChair();
        Chair withBack = new ChairWithBack();

        assertFalse(cheap.hasBack);
        assertEquals(DayOfWeek.MONDAY, cheap.dayOfProducing);
        assertTrue(withBack.hasBack);
        assertEquals(DayOfWeek.TUESDAY, withBack.dayOfProducing);
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

        Chair softChair = new SoftChair();
        Chair anotherChair = new AnotherSoftChair();

        assertEquals("circle", anotherChair.shape);
        assertEquals(anotherChair.hasBack, softChair.hasBack);
        assertArrayEquals(softChair.materials, anotherChair.materials);
        assertEquals(softChair.dayOfProducing, anotherChair.dayOfProducing);
        assertEquals(softChair.legs, anotherChair.legs);

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

        class DefaultChair extends Chair { }

        Chair softChair = new SoftChair();
        Chair anotherChair = new AnotherSoftChair();
        Chair defaultChair = new DefaultChair();

        assertNotEquals(softChair.hasBack, anotherChair.hasBack);
        assertNotEquals(softChair.shape, anotherChair.shape);
        assertNotEquals(softChair.legs, anotherChair.legs);
        assertNotEquals(softChair.dayOfProducing, anotherChair.dayOfProducing);

        assertEquals(defaultChair.legs, anotherChair.legs);
        assertEquals(defaultChair.shape, anotherChair.shape);
        assertEquals(defaultChair.hasBack, anotherChair.hasBack);
        assertEquals(defaultChair.materials[0], anotherChair.materials[0]);
        assertEquals(DayOfWeek.FRIDAY, anotherChair.dayOfProducing);
    }
}
