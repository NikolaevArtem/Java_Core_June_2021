package homework_7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten("bobtail", 2, "grey", "chicken");
        System.out.println(kitten);

        KittenToCatFunction<Cat, Kitten> transform = newKitten -> new Cat(newKitten.getBreed(), new Random().nextInt(12) + 1, newKitten.getColour(), 3);

        Cat cat = transform.grow(kitten);
        System.out.println();
        System.out.println(cat);
    }

}

