package homework_4.custom_annotation;

@CustomAnnotation(name = "Zuza", age = 23)
public class Planet {
    private final String name;
    private final int age;
    private final int speed;

    public Planet() {
        CustomAnnotation annotation = Planet.class.getAnnotation(CustomAnnotation.class);
        name = annotation.name();
        age = annotation.age();
        speed = 23000;
    }

    @Override
    public String toString() {
        return "Name = " + name
                + ", Age = " + age
                + ", Speed = " + speed;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}
