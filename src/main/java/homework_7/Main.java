package homework_7;

import homework_7.function.KittenToCatFunction;
import homework_7.model.Sex;
import homework_7.model.cat_model.Cat;
import homework_7.model.cat_model.MilitaryCat;
import homework_7.model.kitten_model.Kitten;

import java.util.Random;

import static homework_7.model.Sex.*;

public class Main {

    public static void main(String[] args) {

        KittenToCatFunction<Cat, Kitten> kittenToCatFunction = Main::toCat;
        Kitten kitten = new Kitten("Nikita", 0, MALE);
        System.out.println(kittenToCatFunction.grow(kitten));
    }

    private static Cat toCat(Kitten kitten) {
        String catName = (kitten.getSex().equals(MALE) ? "Mr. " : "Ms. ") + kitten.getFirstName();
        int catAge = new Random().nextInt(82) + 18;
        return new Cat(catName, catAge, kitten.getSex(), "student");
    }

}
