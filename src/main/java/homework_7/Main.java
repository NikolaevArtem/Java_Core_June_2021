package homework_7;

public class Main {
    public static void main(String[] args) {
        Kitten kitten1 = new Kitten("Boris", Cat.SEX.MALE, 2, "white", 7);
        Kitten kitten2 = new Kitten("Murka", Cat.SEX.FEMALE, 6, "gray", 5);
        System.out.println(kitten1);
        System.out.println(kitten2);

        KittenToCatFunction<Cat, Kitten> kittenToCatFunction = kit -> {
            String title = kit.getSex().equals(Cat.SEX.MALE) ? "Mr. " : "Ms. ";
            return new Cat(title + kit.getName(),
                    kit.getSex(),
                    kit.getMonths() / 12 + 0.5,
                    "bright " + kit.getColor(),
                    kit.getTailLength() * 1.5);
        };

        Cat cat1 = kittenToCatFunction.grow(kitten1);
        Cat cat2 = kittenToCatFunction.grow(kitten2);

        System.out.println("Kittens has grown.");

        System.out.println(cat1);
        System.out.println(cat2);
    }
}
