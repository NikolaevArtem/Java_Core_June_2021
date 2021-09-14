package homework_7;

import homework_7.kitten_to_cat_function.Cat;
import homework_7.kitten_to_cat_function.Kitten;
import homework_7.kitten_to_cat_function.KittenToCatFunction;

public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten("Murzik", 1);
        KittenToCatFunction function = (k) -> new Cat(k.getName(), k.getAge() + 4);
        Cat cat = function.grow(kitten);
        System.out.println(kitten);
        System.out.println(cat);
    }
}
