package homework_7;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten("murzik", 1, 1.0 );
        Cat cat = kitten.changeKittenToCat(kitten1 -> new Cat (kitten.getName(), kitten.getAge()*5, kitten.getTail_length()*2));
        System.out.println(cat);
    }
}
