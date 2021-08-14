package homework_4.custom_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

//аннотация отмечает поля класса как важные
//priority - приоритет поля при выводе

@Retention(RetentionPolicy.RUNTIME)
@Target(FIELD)
public @interface ImportantField {

    int priority();

}
