package сustomAnnotation;

import java.lang.reflect.Constructor;

public class SimpleClassWithNameField {
    private String name;

    @CustomAnnotation("test name string")
    public SimpleClassWithNameField() {
        try {
            Constructor<? extends SimpleClassWithNameField> constructor = this.getClass ().getConstructor ();
            CustomAnnotation annotation = constructor.getAnnotation(CustomAnnotation.class);
            this.name = annotation.value();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        SimpleClassWithNameField obj = new SimpleClassWithNameField();
        System.out.println(obj.getName());
    }

}
