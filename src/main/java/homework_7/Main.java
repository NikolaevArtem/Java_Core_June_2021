package homework_7;

import homework_7.util.Cat;
import homework_7.util.Kitten;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Kitten kitty = new Kitten(1, "Playful", "White");
        System.out.println("kitty = " + kitty);

        KittenToCatFunction<Cat, Kitten> transform = obj -> new Cat(obj.getAge() + 2, new Random().nextInt(10) + 1, obj.getColor());

        Cat cat = timeToGetOlder(transform, kitty);
        System.out.println("cat = " + cat);
    }

    public static Cat timeToGetOlder(KittenToCatFunction<Cat, Kitten> transform, Kitten kitten) {
        return transform.grow(kitten);
    }
}
