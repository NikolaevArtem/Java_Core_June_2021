package homework_7;

public class Main {
    public static void main(String[] args) {
        KittenToCatFunction<Kitten> myFunction = (kitten -> {
            if (kitten.getAge() < 1.0){
                return new Cat(kitten.getName(), 1.0);
            } else {
                return new Cat(kitten.getName(), kitten.getAge());
            }
        });
        Kitten kitten1 = new Kitten("Shlepa", 0.3);
        Cat cat1 = myFunction.grow(kitten1);
        Kitten kitten2 = new Kitten("Klepa", 1.5);
        Cat cat2 = myFunction.grow(kitten2);
        System.out.println(kitten1);
        System.out.println(cat1);
        System.out.println(kitten2);
        System.out.println(cat2);
    }
}
