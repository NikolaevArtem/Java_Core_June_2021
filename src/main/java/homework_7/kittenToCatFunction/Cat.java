package homework_7.kittenToCatFunction;

public class Cat {
    private int age;
    private String name;
    private Kitten kitten;

    public Cat(int age, String name, Kitten kitten) {
        this.age = age;
        this.name = name;
        this.kitten = kitten;
    }

    public Kitten getKitten() {
        return kitten;
    }

    public void setKitten(Kitten kitten) {
        this.kitten = kitten;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
