package homework_4.custom_annotation;

@FilePathCustomAnnotation
@ClassInfo(date = "15/08/2021", specification = "Class for testing annotations")
public class CustomAnnotationTestClass {

    protected static final String FILE_PATH = CustomAnnotationTestClass.class.getAnnotation(FilePathCustomAnnotation.class).path();

}
