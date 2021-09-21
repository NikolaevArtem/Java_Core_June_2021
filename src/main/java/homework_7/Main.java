package homework_7;

public class Main {

    public static void main(String[] args) {

        ChildKitten childKitten = new ChildKitten("Vasilisa", 0, "black");
        System.out.println("Kitten :" + childKitten);

        Cat grownKitten = ((KittenToCatFunction<Cat, Kitten>) kitten1 -> {
            return new Cat(kitten1.getName(), kitten1.getAge() + 2, "black&white");
        }).grow(childKitten);

        System.out.println("Grown kitten :" + grownKitten);


    }
}
