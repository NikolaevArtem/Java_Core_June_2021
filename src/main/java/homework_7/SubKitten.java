package homework_7;

public class SubKitten extends Kitten{

    private String name;
    private int age;
    private int weight;

    public SubKitten(String name, int age, int weight) {
        super(name,age,weight);
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    static {
        System.out.println(" <SubKitten quiet meow> ... new SubKitten has just appeared! \n");
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
        System.out.println("SubKitten meoww! SubKitten meoww!");
    }

    @Override
    public String toString() {
        return "SubKitten " + name + " is only " + age + " months old and weights just " + weight + " g. So subtiny and subcute! \n";
    }
}
