package homework_4.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Аннотация необходимая, которая позволяет включать отмеченные поля в сгенерированный JSON

public class MyAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface JsonElement {
        public String key() default "";
    }
}
