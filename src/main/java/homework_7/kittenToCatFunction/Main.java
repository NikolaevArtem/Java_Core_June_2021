package homework_7.kittenToCatFunction;

public class Main {

    public static void main(String[] args) {

        Kitten kitten = new EgyptKitten(1, "Push");

        KittenToCatFunction function = x -> {
            if (x instanceof EgyptKitten) {
                return new EgyptCat(x.getAge() + 3, x.getName(), x);
            } else {
                return new SomeCat(x.getAge() + 3, x.getName(), x);
            }
        };

        Cat cat = function.grow(kitten);

        System.out.println("bigCat.getClass() = " + cat.getClass());
        System.out.println("bigCat.getAge() = " + cat.getAge());
        System.out.println("bigCat.getName() = " + cat.getName());
    }

}
