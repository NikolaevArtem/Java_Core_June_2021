package homework_7.kitten_to_cat;

public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten("Joe Bezos", 3, "Billionerra");
        System.out.println(kitten.getClass().getSimpleName() + "\n" +
                kitten);
        Cat kittyToCat = kitten.grow(kitty -> new Cat("Joseph Bezos", kitty.getAge() + 2));
        System.out.println(kittyToCat.getClass().getSimpleName() + "\n" +
                kittyToCat);
    }
    
}
