package homework_4.custom_annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfoCustomAnnotation {
    String author() default "Khlebnikov Evgeniy";
    String date();
    int version() default 1;
    boolean suppressExceptions() default false;
    @MaxFieldLength
    String comments();
}