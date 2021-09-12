package homework_7.kitten_to_cat_function;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten(1, "Kitty");
        System.out.println(kitten);
        Cat cat = kitten
                .transform((k) -> new Cat(k.getAge() * 5, k.getName().substring(0,3)));
        System.out.println(cat);
        Cat strangeCat = new StrangeKitty(2, "Pussy Cat")
                .transform((s) -> new Cat(s.getAge() * 10, s.getName().substring(6)));
        System.out.println(strangeCat);
    }
}
