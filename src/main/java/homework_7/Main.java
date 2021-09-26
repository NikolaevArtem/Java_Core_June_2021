package homework_7;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten("Pupa", 0, 2.5);

        KittenToCatFunction function = (k) -> new Cat(k.getName(), k.getAge() + 4);
        Cat cat = function.grow(kitten);
        System.out.println("kitten = " + kitten);
        System.out.println("cat = " + cat);
    }
}
