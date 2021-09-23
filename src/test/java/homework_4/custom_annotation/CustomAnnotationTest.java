package homework_4.custom_annotation;

import base.UnitBase;
import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomAnnotationTest extends UnitBase {
    @Test
    void testAnnotation() {
        assertEquals( "src/main/resources/custom_file_reader/file.txt", CustomFileReader.class.getAnnotation(FilePath.class).path());
    }
}
