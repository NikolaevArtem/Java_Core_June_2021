package homework_4.custom_annotation;

import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FilePathTest {

    Class<CustomFileReader> obj = CustomFileReader.class;

    @Test
    void testAnnotation() {
        if (obj.isAnnotationPresent(FilePath.class)) {
            Annotation annotation = obj.getAnnotation(FilePath.class);
            FilePath filePath = (FilePath) annotation;

            System.out.println("Class " + CustomFileReader.class.getSimpleName() +
                    " has annotation @" + FilePath.class.getSimpleName());
            assertFalse(filePath.path().isEmpty());
            System.out.println("path: " + filePath.path());
        } else {
            System.out.println("NO ANNOTATION FOUND!");
            throw new AssertionError();
        }
    }

}
