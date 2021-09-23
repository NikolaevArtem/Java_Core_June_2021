package homework_7;

public class Kitten {

    private int age;
    private String name;

    public Kitten(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
