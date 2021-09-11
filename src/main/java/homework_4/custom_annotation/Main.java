package homework_4.custom_annotation;

@CustomAnnotation(v = 1.2f)
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        CustomAnnotation annotation = Main.class.getAnnotation(CustomAnnotation.class);
        System.out.println("Author: " + annotation.DEFAULT_AUTHOR + " (" + annotation.DEFAULT_COUNTRY + "), version: " + annotation.v());
    }
}