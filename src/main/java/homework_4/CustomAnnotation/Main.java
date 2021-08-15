package homework_4.CustomAnnotation;

public class Main {
    public static void main(String[] args) {

        MyTestAnnotationClass test = new MyTestAnnotationClass();
        System.out.println(test.getMyName());
        System.out.println(test.getAge());
    }
}
