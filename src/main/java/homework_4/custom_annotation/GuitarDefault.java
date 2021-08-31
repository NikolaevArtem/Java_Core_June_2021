package homework_4.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.DayOfWeek;
import java.time.Year;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface GuitarDefault {
    String manufacturer() default "A&M guitars";
    String model() default "Sophia";
    int yearOfManufacture() default 2015;
    int serialNumber() default 101;
}
