package homework_4.custom_annotation;


public class HelloGenerator {
    private String name;
    private int age;

    @CustomAnnotation
    public HelloGenerator(String name, int age) {
        if (name == null || name.isEmpty()) {
            String temp;
            try {
                CustomAnnotation customAnnotation = (CustomAnnotation) this.getClass().getConstructor().getDeclaredAnnotations()[0];
                // this.name = customAnnotation.name();
                temp = customAnnotation.name();
            } catch (NoSuchMethodException e) {
                temp = "Aristarch";
            }
            this.name = temp;
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
        HelloGenerator helloGenerator = new HelloGenerator(null, 16);
        System.out.println(helloGenerator);
    }

    @Override
    public String toString() {
        return "Hello " + name + "!" + " You are " + age + " year old!";
    }
}
