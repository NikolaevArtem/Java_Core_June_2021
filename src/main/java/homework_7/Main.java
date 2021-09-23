package homework_7;

public class Main {

    public static void main(String[] args) {

        Kitten kitten = new Kitten(1, "LittleCat");
        KittenToCatFunction func = x -> new Cat(x.getAge() + 5, "Old" + x.getName());

        Cat cat = func.grow(kitten);
        System.out.println(cat);
        System.out.println(cat.getClass());
        System.out.println(kitten);
    }
}
