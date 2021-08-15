package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassInfoTest extends UnitBase {

    private final String AUTHOR_TEST = "Khlebnikov Evgeniy";
    private final String DATE_STRING_TEST = "15/08/2021";
    private final int VERSION_TEST = 1;
    private final String DESCRIPTION_TEST = "Class for testing annotations";

    @Test
    void testAnnotation() {

        assertEquals(AUTHOR_TEST, CustomAnnotationTestClass.class.getAnnotation(ClassInfo.class).author());
        assertEquals(DATE_STRING_TEST, CustomAnnotationTestClass.class.getAnnotation(ClassInfo.class).date());
        assertEquals(VERSION_TEST, CustomAnnotationTestClass.class.getAnnotation(ClassInfo.class).version());
        assertEquals(DESCRIPTION_TEST, CustomAnnotationTestClass.class.getAnnotation(ClassInfo.class).specification());

    }
}