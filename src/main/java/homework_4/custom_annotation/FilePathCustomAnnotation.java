package homework_4.custom_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilePathCustomAnnotation {
    String path() default "C:\\Users\\admin\\IdeaProjects\\Java_Core_June_2021\\src\\main\\resources\\custom_file_reader\\testFile.txt";
}