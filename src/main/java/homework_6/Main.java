package homework_6;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsMutableGenerator, String> myHashMap = new HashMap<>();
        MapProblemsMutableGenerator mapProblemsMutableGenerator = new MapProblemsMutableGenerator(1);

        myHashMap.put(mapProblemsMutableGenerator, "A");

        mapProblemsMutableGenerator.setValue(2);
        System.out.println(myHashMap.get(mapProblemsMutableGenerator));
    }
}
