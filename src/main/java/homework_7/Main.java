package homework_7;

import homework_7.entity.Cat;
import homework_7.entity.Kitten;

public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten("Kitty Tom", 1, 2);
        Cat grownUpCat = kitten.grow(k -> new Cat(k.getName().replace("Kitty", "Big"), k.getAge() + 1, k.getWeight() * 2));
        System.out.println(grownUpCat);
    }
}
