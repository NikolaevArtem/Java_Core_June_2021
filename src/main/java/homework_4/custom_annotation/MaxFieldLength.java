package homework_4.custom_annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MaxFieldLength {
    int maxLength() default 100;
}
