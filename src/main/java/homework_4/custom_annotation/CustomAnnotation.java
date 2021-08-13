package homework_4.custom_annotation;

import homework_3.library.Author;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    float v() default 1.1f;
    Author DEFAULT_AUTHOR = new Author("Rog Elena", "Russia", null);
    String DEFAULT_COUNTRY = DEFAULT_AUTHOR.getCountry();
}