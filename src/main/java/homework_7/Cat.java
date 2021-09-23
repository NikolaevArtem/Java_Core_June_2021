package homework_7;

public class Cat {
    private String name;
    private String breed;
    private int age;

    public Cat(String name, String breed, int age){
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat: " + name + ", " + breed + ", cat is " + age + " years old!";
    }
}
