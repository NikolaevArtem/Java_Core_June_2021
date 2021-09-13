package homework_7.catToKittenFunction;

public class Main {

    public static void main(String[] args) {

        Kitten smallCat = new Kitten(1, "Push");
        KittenToCatFunction function = x -> new Cat(x.getAge() + 2, x.getName());
        Cat oldCat = function.grow(smallCat);

        System.out.println("oldCat.getClass() = " + oldCat.getClass());
        System.out.println("oldCat.getAge() = " + oldCat.getAge());
        System.out.println("oldCat.getName() = " + oldCat.getName());
    }

}
