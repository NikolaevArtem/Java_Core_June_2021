package homework.homework_4.custom_annotation;

import homework_4.custom_annotation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomAnnotationTest {


    @Test
    public void givenObjectNotSerializedThenExceptionThrown() throws JsonSerializationException {
        Object object = new Object();
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        assertThrows(JsonSerializationException.class, () -> serializer.convertToJson(object));
    }

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person dvasch = new Person("dima", "vaschenko", "35");
        ObjectToJsonConverter converter = new ObjectToJsonConverter();
        String jsonString = converter.convertToJson(dvasch);
        System.out.println(jsonString);
        assertEquals("{\"personAge\":\"35\",\"firstName\":\"Dima\",\"lastName\":\"Vaschenko\"}", jsonString);
    }







}
