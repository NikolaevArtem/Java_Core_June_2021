package homework_4.custom_annotation;

public class HelloGenerator {
    private String name;
    private int age;

    public static void main(String args[]) {
        HelloGenerator helloGenerator = new HelloGenerator();
        HelloGenerator helloGenerator1 = new HelloGenerator(null, 5);
        System.out.println(helloGenerator);
        System.out.println(helloGenerator1);
    }

    @CustomAnnotation
    public HelloGenerator() {
        String temp;
        try {
            CustomAnnotation customAnnotation = (CustomAnnotation) this.getClass().getConstructor().getDeclaredAnnotations()[0];
            temp = customAnnotation.name();
        } catch (NoSuchMethodException e) {
            temp = "Aristarch";
            this.age = 50;
        }
        this.name = temp;
        this.age = 15;
    }

    @CustomAnnotation
    public HelloGenerator(String name, int age) {
        try {
            CustomAnnotation customAnnotation = (CustomAnnotation) this.getClass().getConstructor().getDeclaredAnnotations()[0];
            if (name == null) {
                this.name = customAnnotation.name();
            } else {
                this.name = name;
            }
            //this.name = name;
            this.age = age;
        } catch (NoSuchMethodException e) {
            name = "Aristarch";
            this.age = 5090;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Hello " + name + "!" + " You are " + age + " year old!";
    }
}
