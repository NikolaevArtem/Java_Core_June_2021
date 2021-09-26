package homework_6;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        HashMap<MapProblemsMutableGenerator, Integer> mutableMap = new HashMap<>();

        MapProblemsMutableGenerator first = new MapProblemsMutableGenerator(new StringBuilder("first"));
        MapProblemsMutableGenerator second = new MapProblemsMutableGenerator(new StringBuilder("second"));

        mutableMap.put(first, 1);
        mutableMap.put(second, 2);

        System.out.println("Before key mutation: ");
        System.out.println("mutableMap.get(first) = " + mutableMap.get(first));
        System.out.println("mutableMap.get(second) = " + mutableMap.get(second));


        first.getMapKey().append("a");
        second.getMapKey().append("a");

        System.out.println("After key mutation: ");
        System.out.println("mutableMap.get(first) = " + mutableMap.get(first));
        System.out.println("mutableMap.get(second) = " + mutableMap.get(second));

    }

}
