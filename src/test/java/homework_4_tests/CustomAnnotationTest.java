package homework_4_tests;

import homework_4.custom_annotation.Student;
import homework_4.custom_annotation.StudentInformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomAnnotationTest {

    @Test
    void givenMinimumParametersInput_whenConstructor_thenAllParametersFilled() {
        Student student = new Student("Oleg", "Oleg@gmail.com");

        assertEquals("Oleg", student.getName());
        assertEquals("Oleg@gmail.com", student.getEmail());
        assertEquals("Saint-Petersburg", student.getCity());
        assertEquals("Java", student.getLanguage());
    }

    @Test
    void givenParametersInput_whenConstructor_thenCorrectParameters() {
        Student student = new Student("Olga", "Olga@gmail.com", "Moscow", "Python");

        assertEquals("Olga", student.getName());
        assertEquals("Olga@gmail.com", student.getEmail());
        assertEquals("Moscow", student.getCity());
        assertEquals("Python", student.getLanguage());
    }

    @Test
    void givenNotAllParametersInput_whenConstructor_thenAllParametersFilled() {
        Student student = new Student("Pasha", "Pasha@gmail.com", "Samara");

        assertEquals("Pasha", student.getName());
        assertEquals("Pasha@gmail.com", student.getEmail());
        assertEquals("Samara", student.getCity());
        assertEquals("Java", student.getLanguage());
    }

    @Test
    void givenImplementedAnnotation_whenGetDeclaredAnnotation_thenNotNull() {
        assertNotNull(Student.class.getDeclaredAnnotation(StudentInformation.class));
    }
}
