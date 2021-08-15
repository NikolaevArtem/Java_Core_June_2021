package homework_4.custom_annotation;

@FilePathCustomAnnotation
@ClassInfoCustomAnnotation(date = "15/08/2021", description = "Class for testing annotations")
public class CustomAnnotationTestClass {

    protected static final String FILE_PATH = CustomAnnotationTestClass.class.getAnnotation(FilePathCustomAnnotation.class).path();

}
