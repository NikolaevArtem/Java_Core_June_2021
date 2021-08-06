package homework_4.custom_annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FilePath {
    String path() default "src/main/resources/custom_file_reader/example.txt";
}
