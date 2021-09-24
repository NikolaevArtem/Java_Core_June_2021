package homework_7;

import homework_7.pets.Cat;
import homework_7.pets.Kitten;

public class Main {
    public static void main(String[] args) {

        Kitten kitten = new Kitten("Lilac", 1, 1.5);
        System.out.println(kitten);

        KittenToCatFunction<Kitten, Cat> function = (k -> new Cat(k.getColor(),
                k.getAgeInMonth() + 11, k.getWeight() * 2.5));

        Cat cat = function.grow(kitten);
        System.out.println(cat);

    }
}