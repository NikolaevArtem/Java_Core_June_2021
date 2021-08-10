package homework_4.customAnnotation;

import java.lang.reflect.Constructor;


public class Cat {

    String testValue;

    @MyAnnotation
    public Cat() {
        try {
            Constructor constructor = this.getClass ().getConstructor (null);
            MyAnnotation myAnnotation = (MyAnnotation) constructor.getAnnotation (MyAnnotation.class);
            this.testValue = myAnnotation.value ();
        } catch (NoSuchMethodException e) {
            e.printStackTrace ();
        }
    }
}
