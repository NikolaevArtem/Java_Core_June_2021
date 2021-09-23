package homework_7;

import homework_7.animals.Cat;
import homework_7.animals.Kitten;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten("Simon", 1, 0.5);
        System.out.println(kitten);

        KittenToCatFunction<Kitten, Cat> function = (k -> new Cat(k.getName(),
                k.getAge() + 1, k.getWeight() * 3));

        Cat cat = function.grow(kitten);
        System.out.println(cat);
    }
}
