package homework_4.custom_annotation;

@MyAnnotation
public class MyTestAnnotationClass {

    String myName;
    int age;

    public MyTestAnnotationClass() {
        myName = getClass().getAnnotation(MyAnnotation.class).name();
        age = this.getClass().getAnnotation(MyAnnotation.class).age();
    }

    public MyTestAnnotationClass(int age) {
        myName = getClass().getAnnotation(MyAnnotation.class).name();
        this.age = age;
    }

    public MyTestAnnotationClass(String myName) {
        this.myName = myName;
        age = this.getClass().getAnnotation(MyAnnotation.class).age();
    }

    public MyTestAnnotationClass(String myName, int age) {
        this.myName = myName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getMyName() {
        return myName;
    }
}
