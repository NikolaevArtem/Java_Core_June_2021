package homework_4.custom_annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyCustomAnnotationTest {
    @Test
    public void myTest(){
        MyClass myClass = new MyClass();
        assertEquals("MyClass{id=1, name='Serega', nicknames=[TaTaY, OzoneTaTaY]}", myClass.toString());
    }
}
