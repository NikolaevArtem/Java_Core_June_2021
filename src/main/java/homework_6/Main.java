package homework_6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        MapProblemsMutableGenerator obj1 = new MapProblemsMutableGenerator("Jorge", true, 23);
        MapProblemsMutableGenerator obj2 = new MapProblemsMutableGenerator("Ivan", true, 28);

        Map<MapProblemsMutableGenerator, String> map = new HashMap<>();
        map.put(obj1, "EN");
        map.put(obj2, "NL");

        System.out.println(map.get(obj1));
        System.out.println(map.get(obj2));
    }

}
