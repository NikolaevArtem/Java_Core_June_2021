package homework_7;

public class Main {

    public static void main(String[] args) {
        Kitten barsik = new Kitten("Barsik", 2.5, 4);
        System.out.println(barsik.toString());

        KittenToCatFunction ktc = kitten -> new Cat(kitten.getName(), kitten.getWeight() + 3, 10);

        Cat grownUpBarsik = ktc.grow(barsik);
        System.out.println(grownUpBarsik.toString());
    }
}
