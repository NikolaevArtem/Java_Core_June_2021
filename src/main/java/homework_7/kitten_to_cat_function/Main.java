package homework_7.kitten_to_cat_function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Kitten martha = new Kitten("Martha", Cat.Sex.FEMALE, "red",
                12, "Daina", "Boris", 3);
        Kitten martin = new Kitten("Martin", Cat.Sex.MALE, "red and white",
                12, "Daina", "Boris", 3);
        Kitten martisha = new Kitten("Martisha", Cat.Sex.MALE, "black and white",
                12, "Martha", "Martin", 3);

        List<Kitten> kittens = new ArrayList<>();
        kittens.add(martha);
        kittens.add(martin);
        kittens.add(martisha);

        KittenToCatFunction<Kitten, Cat> function = k -> new Cat(k.getName(), k.getSex(), k.getAgeInMonths() / 12, k.getColour());
        Cat[] cats = kittens.stream().map(k -> function.grow(k)).toArray(Cat[]::new);
        Arrays.stream(cats).forEach(System.out::println);
    }
}