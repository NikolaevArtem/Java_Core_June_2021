package homework_4.custom_annotation;

import java.lang.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;


@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfoCustomAnnotation {
    String author() default "Khlebnikov Evgeniy";
    String date();
    int version() default 1;
    String description();
}
