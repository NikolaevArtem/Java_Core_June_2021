package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsGenerator, String> mpcg = new HashMap<>();
        MapProblemsGenerator one = new MapProblemsGenerator(1, "one");
        MapProblemsGenerator anotherOne = new MapProblemsGenerator(1, "one");
        MapProblemsGenerator two = new MapProblemsGenerator(2, "two");
        MapProblemsGenerator three = new MapProblemsGenerator(3, "three");
        MapProblemsGenerator four = new MapProblemsGenerator(4, "four");

        mpcg.put(one, "first");
        mpcg.put(two, "second");
        mpcg.put(three, "third");
        mpcg.put(four, "fourth");

        System.out.println("equals works correctly: one.equals(anotherOne) gives " + one.equals(anotherOne));
        System.out.println("Attempts to get values give:");
        System.out.println(mpcg.get(one));
        System.out.println(mpcg.get(two));
        System.out.println(mpcg.get(three));
        System.out.println(mpcg.get(four));
    }
}
