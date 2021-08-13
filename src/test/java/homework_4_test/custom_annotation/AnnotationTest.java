package homework_4_test.custom_annotation;

import homework_4.custom_annotation.DefaultUserInfo;
import homework_4.custom_annotation.Profile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AnnotationTest {

    @Test
    void givenConstructorParameters_whenClassConstructor_thenParametersAssigned() {
        String expectedName = "Obama";
        int expectedId = 44;

        Profile profile = new Profile("Obama", 44);

        assertEquals(expectedName, profile.getName());
        assertEquals(expectedId, profile.getId());
    }

    @Test
    void givenCheckAnnotation_whenGetDeclaredAnnotation_thenNotNull() {
        assertNotNull(Profile.class.getDeclaredAnnotation(DefaultUserInfo.class));
    }

    @Test
    void givenNoConstructorParameters_whenClassConstructor_thenDefaultParametersAssigned() {
        String expectedName = "Nikita";
        int expectedId = 1;

        Profile profile = new Profile();

        assertEquals(expectedName, profile.getName());
        assertEquals(expectedId, profile.getId());
    }
}