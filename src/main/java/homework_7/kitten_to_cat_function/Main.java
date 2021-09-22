package homework_7.kitten_to_cat_function;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Anfisa", 10);
        Kitten kitten = new Kitten("Sam", 3, "test");

        KittenToCatFunction kittenToCatFunction = newKitten -> new Cat(newKitten.getName() + "Cat", newKitten.getAge() + 10);
        Cat oldKitten = kittenToCatFunction.grow(kitten);

        System.out.println(cat);
        System.out.println(kitten);
        System.out.println(oldKitten);
    }
}
