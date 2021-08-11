package homework_4.customAnnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
@Inherited
public @interface ClassCoffeeAnnotation {
    enum Size {SMALL, MEDIUM, BIG}
    Size size() default Size.MEDIUM;
    boolean hasMilk() default false;
    int price();

}

@Retention(RetentionPolicy.RUNTIME)
@Target(METHOD)
@interface AskForCoffeeAnnotation {
    String value();
}

@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface StartMakingCoffee {
}

@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface StopMakingCoffee {
}

