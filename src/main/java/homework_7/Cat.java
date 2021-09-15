package homework_7;

public class Cat {
    private String name;
    private int age;
    private int weight;

    static {
        System.out.println(" My \"MEOW\" grows! I wanna eat! \n");
    }

    public Cat(String name, int  age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void Meow() {
        System.out.println("This is real MEOW! I wanna eat!");
    }

    @Override
    public String toString() {
        return "Cat " + name + " is " + age + " months old and weights " + weight + " gr. Truly mature cat! \n";
    }

}
