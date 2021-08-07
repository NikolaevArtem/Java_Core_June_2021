package homework_4.customAnnotation;

import java.lang.annotation.Annotation;

@MyAnnotation(value = "default_value")
public class Cat {

    public Annotation value;

    public Cat()  {
        this.value = Cat.class.getAnnotations()[0];
    }
}
