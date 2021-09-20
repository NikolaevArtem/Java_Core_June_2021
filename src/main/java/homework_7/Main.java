package homework_7;

import homework_7.kitten_to_cat_function.Cat;
import homework_7.kitten_to_cat_function.Kitten;
import homework_7.kitten_to_cat_function.KittenToCatFunction;

public class Main {
    public static void main(String[] args) {
        Kitten rudolf = new Kitten("Rudolf", 3, "Gottalot");
        Cat buchi = new Cat("Buchi", 12);

        KittenToCatFunction kittenToCat = kitten -> new Cat( kitten.getName(), kitten.getAge() + 10);
        Cat grewRudolf = kittenToCat.grow(rudolf);

        System.out.println(buchi);
        System.out.println(rudolf);
        System.out.println(grewRudolf);
    }
}