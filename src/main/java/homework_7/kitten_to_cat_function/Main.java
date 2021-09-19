package homework_7.kitten_to_cat_function;

public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten(1, 1);
        KittenToCatFunction<Kitten, Cat> catGrow = e -> new Cat(e.getAge() + 1, e.getWeight() + 2);
        Cat cat = catGrow.grow(kitten);
        System.out.println(kitten);
        System.out.println(cat);
    }

}
