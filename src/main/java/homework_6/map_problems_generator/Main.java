package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsGenerator, String> mpg = new HashMap<>();
        MapProblemsGenerator one = new MapProblemsGenerator(1, "one");
        MapProblemsGenerator anotherOne = new MapProblemsGenerator(1, "one");
        MapProblemsGenerator two = new MapProblemsGenerator(2, "two");
        MapProblemsGenerator three = new MapProblemsGenerator(3, "three");
        MapProblemsGenerator four = new MapProblemsGenerator(4, "four");

        mpg.put(one, "first");
        mpg.put(two, "second");
        mpg.put(three, "third");
        mpg.put(four, "fourth");

        System.out.println("equals works correctly: one.equals(anotherOne) gives " + one.equals(anotherOne));
        System.out.println("Attempts to get values give:");
        System.out.println(mpg.get(one));
        System.out.println(mpg.get(two));
        System.out.println(mpg.get(three));
        System.out.println(mpg.get(four));

        HashMap<MapProblemsCollisionGenerator, String> mpcg = new HashMap<>();
        MapProblemsCollisionGenerator firstKey = new MapProblemsCollisionGenerator(1);
        MapProblemsCollisionGenerator secondKey = new MapProblemsCollisionGenerator(2);
        MapProblemsCollisionGenerator thirdKey = new MapProblemsCollisionGenerator(3);

        mpcg.put(firstKey, "first");
        mpcg.put(secondKey, "second");
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
