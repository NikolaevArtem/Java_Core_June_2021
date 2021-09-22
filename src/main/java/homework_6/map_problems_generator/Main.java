package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsGenerator, String> mpg = new HashMap<>();
        MapProblemsGenerator one = new MapProblemsGenerator(new StringBuilder("one"));
        MapProblemsGenerator anotherOne = new MapProblemsGenerator(new StringBuilder("one"));
        MapProblemsGenerator two = new MapProblemsGenerator(new StringBuilder("two"));

        mpg.put(one, "first");
        mpg.put(two, "second");
        System.out.println("Examples for the MapProblemsGenerator:\n");
        System.out.println("equals works correctly: one.equals(anotherOne) gives " + one.equals(anotherOne));
        System.out.println("Attempts to get values give:");
        System.out.println(mpg.get(one));
        System.out.println(mpg.get(two));
        System.out.println("Attempts to get values after changing keys give:");

        one.getValue().append("asd");
        two.getValue().append("asd");

        System.out.println(mpg.get(one));
        System.out.println(mpg.get(two));

        HashMap<MapProblemsCollisionGenerator, String> mpcg = new HashMap<>();
        MapProblemsCollisionGenerator firstKey = new MapProblemsCollisionGenerator(1);
        MapProblemsCollisionGenerator secondKey = new MapProblemsCollisionGenerator(2);
        MapProblemsCollisionGenerator thirdKey = new MapProblemsCollisionGenerator(3);

        mpcg.put(firstKey, "first");
        mpcg.put(secondKey, "second");
        System.out.println("\nExamples for the MapProblemsCollisionGenerator:\n");

        System.out.println("After 2 calls put() method");
        System.out.println("Collisions occurred for the firstKey " + firstKey.getCountCallEquals() + " times");
        System.out.println("Collisions occurred for the secondKey " + secondKey.getCountCallEquals() + " times");
        mpcg.put(thirdKey, "third");
        System.out.println("After 3 calls put() method");
        System.out.println("Collisions occurred for the firstKey " + firstKey.getCountCallEquals() + " times");
        System.out.println("Collisions occurred for the secondKey " + secondKey.getCountCallEquals() + " times");
        System.out.println("Collisions occurred for the thirdKey " + thirdKey.getCountCallEquals() + " times");
        System.out.println("Attempts to get values give:");
        System.out.println(mpcg.get(firstKey));
        System.out.println(mpcg.get(secondKey));
        System.out.println(mpcg.get(thirdKey));
        System.out.println("After 3 calls get() method");
        System.out.println("Collisions occurred for the firstKey " + firstKey.getCountCallEquals() + " times");
        System.out.println("Collisions occurred for the secondKey " + secondKey.getCountCallEquals() + " times");
        System.out.println("Collisions occurred for the thirdKey " + thirdKey.getCountCallEquals() + " times");
    }
}
