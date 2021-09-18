package homework_7.kittenToCatFunction;

public class Main {

    public static void main(String[] args) {

        Kitten smallCat = new Kitten(1, "Push");
        KittenToCatFunction function = x -> new Cat(x.getAge() + 2, x.getName(), smallCat);
        Cat bigCat = function.grow(smallCat);

        System.out.println("bigCat.getClass() = " + bigCat.getClass());
        System.out.println("bigCat.getAge() = " + bigCat.getAge());
        System.out.println("bigCat.getName() = " + bigCat.getName());
    }

}
