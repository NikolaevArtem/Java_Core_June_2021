package homework_4.custom_annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "Khlebnikov Evgeniy";
    int version() default 1;
    boolean suppressExceptions() default false;
    String description();
}