package homework_7;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Kitten kitty = new Kitten("Vasilek", "Vasilii", 1, Color.RED, "Tiny blue collar");

        KittenToCatFunction kittenToCat = kitten ->
                new Cat(kitten.fullName, kitten.age + 2, kitten.color, "Grown ups init collar");

        Cat cat = kittenToCat.grow(kitty);

        System.out.println(cat);
    }
}
