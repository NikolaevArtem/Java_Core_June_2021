package homework_4.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//https://skillbox.ru/media/base/kak-napisat-annotatsiyu-na-java-za-5-shagov/
//https://web-shpargalka.ru/java-annotacii-zachem-oni-nuzhny.php
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface GuitarDefault {
    String manufacturer() default "A&M guitars";
    String model() default "Sophia";
    int yearOfManufacture() default 2015;
    int serialNumber() default 101;
}
