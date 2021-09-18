package homework_3.immutable_class;

public final class Planet {
    private final int age;
    private final String name;
    private final int speed;

    public Planet(int age, String name, int speed) {
        this.age = age;
        this.name = name;
        this.speed = speed;
    }

    public Planet(int age, String name) {
        this.age = age;
        this.name = name;
        this.speed = 10000;
    }

    public Planet(String name) {
        this.name = name;
        speed = 10000;
        age = 0;
    }

    public Planet() {
        this.speed = 10000;
        this.age = 0;
        this.name = null;
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

    public Planet setSpeed(int speed) {
        Planet planet = new Planet(this.age, this.name, speed);
        return planet;
    }

    @Override
    public String toString() {
        return "Name = " + name
                + ", Age = " + age
                + ", Speed = " + speed;
    }
}
