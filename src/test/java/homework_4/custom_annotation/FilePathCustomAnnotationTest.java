package homework_4.custom_annotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilePathCustomAnnotationTest extends UnitBase {

    private final String DEFAULT_FILE_PATH_TEST = "./src/main/resources/custom_file_reader/testFile.txt";

    @Test
    void testAnnotation() {

        assertEquals( DEFAULT_FILE_PATH_TEST, CustomAnnotationTestClass.class.getAnnotation(FilePathCustomAnnotation.class).path());

    }
}