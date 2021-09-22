package homework_4.custom_annotation;

import java.util.Arrays;
@MyCustomAnnotation(name = "Serega")
public class MyClass {
    private int id;
    private String name;
    private String[] nicknames;

    public MyClass(){
        MyCustomAnnotation myCustomAnnotation = this.getClass().getAnnotation(MyCustomAnnotation.class);
        this.id = myCustomAnnotation.id();
        this.name = myCustomAnnotation.name();
        this.nicknames = myCustomAnnotation.nicknames();
    }

    public MyClass(int id, String name, String[] nicknames) {
        this.id = id;
        this.name = name;
        this.nicknames = nicknames;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nicknames=" + Arrays.toString(nicknames) +
                '}';
    }
}
