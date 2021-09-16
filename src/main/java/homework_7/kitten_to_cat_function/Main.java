package homework_7.kitten_to_cat_function;

public class Main {
    public static void main(String[] args) {
        KittenToCatFunction ktc = new KittenToCatFunction() {
            @Override
            public Cat grow(Kitten kitten) {
                return new Cat(kitten.getAge() * 5, kitten.getName().substring(0, 3));
            }
        };

        Kitten kitten = new Kitten(1, "Kitten");
        Cat cat = ktc.grow(kitten);
        Cat anotherCat = ktc.grow(new Kitty(2, "Kotik"));
        System.out.println(cat);
        System.out.println(anotherCat);
    }
}
