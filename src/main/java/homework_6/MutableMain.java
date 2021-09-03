package homework_6;

import java.util.HashMap;

public class MutableMain {
    public static void main(String[] args) {

        HashMap<MapProblemsMutableGenerator, Integer> map = new HashMap();

        MapProblemsMutableGenerator key = new MapProblemsMutableGenerator("name");
        MapProblemsMutableGenerator key2 = new MapProblemsMutableGenerator("name");

        System.out.println(key.equals(key2));

        map.put(key, 1);
        System.out.println(1 == map.get(key));

        key.setName("NewName");

        System.out.println(key.getName());
        System.out.println(map.get(key));
    }
}
