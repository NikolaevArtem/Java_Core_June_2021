package homework_7;

public class Kitten {
    private String name;
    private int age;
    private int weight;

    static {
        System.out.println(" <quiet meow> ... new kitten has just appeared! \n");
    }

    public Kitten(String name, int  age, int weight) {
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
        System.out.println("meoww! meoww!");
    }

    @Override
    public String toString() {
        return "Kitten " + name + " is only " + age + " months old and weights just " + weight + " g. So tiny and cute! \n";
    }

}
