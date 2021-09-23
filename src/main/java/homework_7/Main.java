package homework_7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Myrka", 12);
        Kitten tom = new Kitten("Tom", 3, "YYY");

        KittenToCatFunction kittenToCatFunction = kitten -> new Cat(kitten.getName() + "Cat", kitten.getAge() + 10);
        Cat oldTom = kittenToCatFunction.grow(tom);

        System.out.println(cat);
        System.out.println(tom);
        System.out.println(oldTom);

    }
}
