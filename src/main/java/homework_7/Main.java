package homework_7;

import homework_7.kitten_to_cat_function.Cat;
import homework_7.kitten_to_cat_function.Kitten;
import homework_7.kitten_to_cat_function.KittenToCatFunction;

import java.awt.*;

@SuppressWarnings("unchecked")
public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten(1, "Barsik", Color.BLACK);
        System.out.println("kitten: " + " " + kitten);

        KittenToCatFunction transform = o -> new Cat(o.getAge() + 3, o.getName(), o.getColor());

        Cat growKitten = transform.grow(kitten);
        System.out.println("Kitten grow: " + " " + growKitten);
    }
}
