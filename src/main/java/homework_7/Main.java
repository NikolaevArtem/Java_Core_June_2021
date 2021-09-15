package homework_7;

public class Main {

    public static void main(String[] args) {
        KittenToCatFunction<Kitten> timeToGrow = k -> new Cat(k.getName(), 12, k.getWeight()*4);

        Kitten youngKitten = new Kitten("Vaskya", 2, 250);
        System.out.println(youngKitten);

//      then..
        Cat matureCat = timeToGrow.grow(youngKitten);
        System.out.println(matureCat);

//        Let`s try to make Cat from Cat
        Cat oldCat = new Cat("Serj", 24, 2000);
//        Cat old = timeToGrow.grow(oldCat); doesn`t work

//        Let`s try to make Cat from SubKitten
        SubKitten subKitten = new SubKitten("Antoha", 8, 500);
        Cat matureCatFromSubKitten = timeToGrow.grow(subKitten); // it works
        System.out.println(matureCatFromSubKitten);
    }


}
