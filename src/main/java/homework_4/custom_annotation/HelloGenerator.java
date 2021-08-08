package homework_4.custom_annotation;

@CustomAnnotation
public class HelloGenerator {
    private String name;
    private int age;

    public HelloGenerator(String name, int age) {
        if (name == null || name.isEmpty()) {
            CustomAnnotation customAnnotation = (CustomAnnotation) this.getClass().getDeclaredAnnotations()[0];
            this.name = customAnnotation.name();
        } else {
            this.name = name;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        HelloGenerator helloGenerator = new HelloGenerator("", 16);
        System.out.println(helloGenerator);
    }

    @Override
    public String toString() {
        return "Hello " + name + "!" + " You are " + age + " year old!";
    }
}
