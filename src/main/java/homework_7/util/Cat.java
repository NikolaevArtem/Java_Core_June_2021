package homework_7.util;

public class Cat {

    private int age;
    private final int activityLevel;
    private final String color;

    public Cat(int age, int activityLevel, String color) {
        this.age = age;
        this.activityLevel = activityLevel;
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", activityLevel=" + activityLevel +
                ", color='" + color + '\'' +
                '}';
    }
}
