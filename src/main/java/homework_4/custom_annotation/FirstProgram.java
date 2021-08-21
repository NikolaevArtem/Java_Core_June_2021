package homework_4.custom_annotation;

@CustomAnnotation
public class FirstProgram {
    private static String output;

    public FirstProgram(String s) {
        output = s;
        System.out.println(output);
    }

    public FirstProgram() {
        final CustomAnnotation annotation = FirstProgram.class.getAnnotation(CustomAnnotation.class);
        output = annotation.output();
        System.out.println(output);
    }

}

