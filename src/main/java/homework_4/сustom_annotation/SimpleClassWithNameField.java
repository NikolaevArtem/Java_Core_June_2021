package homework_4.сustom_annotation;

import java.lang.reflect.Constructor;

public class SimpleClassWithNameField {
    private String name;

    @CustomAnnotation("test name string")
    public SimpleClassWithNameField(String name) {
        Constructor<? extends SimpleClassWithNameField> constructor;
        try {
            constructor = this.getClass().getConstructor(String.class);
            CustomAnnotation annotation = constructor.getAnnotation(CustomAnnotation.class);
            if (annotation != null) this.name = annotation.value();
            if (!name.isEmpty()) this.name = name;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

}
