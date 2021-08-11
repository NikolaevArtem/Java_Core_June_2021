package homework_4.custom_annotation;

import java.lang.annotation.*;


@Target({ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResourcesPath {

    String dirPath() default "./src/main/resources/custom_file_reader/";

}
