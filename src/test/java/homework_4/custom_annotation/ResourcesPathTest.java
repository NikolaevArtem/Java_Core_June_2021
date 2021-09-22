package homework_4.custom_annotation;

import homework_4.custom_file_reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourcesPathTest {

    @Test
    void testAnnotation() {
            Constructor[] constructors = CustomFileReader.class.getConstructors();
            Constructor myConstructor = null;
            for (Constructor constructor : constructors) {
                if (constructor.isAnnotationPresent(ResourcesPath.class)) {
                    myConstructor = constructor;
                    break;
                }
            }

            if (myConstructor != null) {
                String constructorType = "Empty constructor";
                if (myConstructor.getParameterCount() != 0) {
                    constructorType = "Constructor with parameters";
                }
                System.out.println(constructorType + " in " + CustomFileReader.class.getSimpleName() + " class " +
                        "has annotation @" + ResourcesPath.class.getSimpleName());
            } else {
                System.out.println("No annotated constructor found in " + CustomFileReader.class.getSimpleName());
                throw new AssertionError();
            }
            assertTrue(myConstructor.isAnnotationPresent(ResourcesPath.class));
    }

}
