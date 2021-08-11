package homework_4.custom_annotation;

import java.awt.*;
import java.lang.annotation.*;
import java.time.DayOfWeek;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface ChairConstructor {

    int legs() default 4;
    boolean hasBack() default false;
    String shape() default "square";
    String[] materials() default "wood";
    DayOfWeek dayOfProducing();

}

