package homework_7;

public class Main {

    public static void main(String[] args) {
        Kitten kitten = new Kitten("murzik", 1, 1.0 );
        Kitten kitten1 = new Kitten("sadCat", 12, 2.3);
        Cat cat = kitten.changeKittenToCat(kit -> new Cat (kitten.getName(), kitten.getAge()*5, kitten.getTail_length()*2));
        Cat cat2 = kitten.changeKittenToCat(kit -> new Cat (kitten1.getName(), kitten1.getAge()*5, kitten1.getTail_length()*2));
        System.out.println(cat);
    }
}
