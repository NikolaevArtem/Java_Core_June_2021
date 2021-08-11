package homework_4.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyCustomAnnotation {
    int id() default  1;
    String name() default "Sergey";
    String [] nicknames()  default  {"TaTaY", "OzoneTaTaY"};
}
