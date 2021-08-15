package homework_4.CustomAnnotation;

import base.UnitBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyTestAnnotationClassTest extends UnitBase {

    @Test
    void Empty_Const() {
        MyTestAnnotationClass myClass = new MyTestAnnotationClass();
        assertEquals("MySuperName", myClass.getMyName());
        assertEquals(2, myClass.getAge());
    }

    @Test
    void Name_Const() {
        MyTestAnnotationClass myClass = new MyTestAnnotationClass("Stepan");
        assertEquals("Stepan", myClass.getMyName());
        assertEquals(2, myClass.getAge());
    }
    @Test
    void Age_Const() {
        MyTestAnnotationClass myClass = new MyTestAnnotationClass(44);
        assertEquals("MySuperName", myClass.getMyName());
        assertEquals(44, myClass.getAge());
    }
    @Test
    void Full_Const() {
        MyTestAnnotationClass myClass = new MyTestAnnotationClass("Anna", 33);
        assertEquals("Anna", myClass.getMyName());
        assertEquals(33, myClass.getAge());
    }
}