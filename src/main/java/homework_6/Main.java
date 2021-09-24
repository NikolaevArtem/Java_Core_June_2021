package homework_6;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<MapProblemsMutableGenerator, Integer> myMap = new HashMap<>();
        MapProblemsMutableGenerator mutab = new MapProblemsMutableGenerator(1);

        myMap.put(mutab, 100);
        System.out.println(myMap.get(mutab));

        mutab.setId(3);
        System.out.println(myMap.get(mutab));
    }
}
