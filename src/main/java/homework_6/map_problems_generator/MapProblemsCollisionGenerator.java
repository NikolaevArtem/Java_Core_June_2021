package homework_6.map_problems_generator;

import java.util.HashMap;

public class MapProblemsCollisionGenerator {

    public static void main(String[] args) {

        HashMap<MapProblemsMutableGenerator, Integer> myHashMap = new HashMap<>();

        MapProblemsMutableGenerator bugger1 = new MapProblemsMutableGenerator("Sasha", "bugger", 40);
        MapProblemsMutableGenerator bugger2 = new MapProblemsMutableGenerator("Pasha", "troubleMaker", 30);
        MapProblemsMutableGenerator bugger3 = new MapProblemsMutableGenerator("Yura", "juniorForever", 35);

        System.out.println("Put bugger 1");
        myHashMap.put(bugger1, 1);
        System.out.println("Put bugger 2");
        myHashMap.put(bugger2, 2);
        System.out.println("Put bugger 3");
        myHashMap.put(bugger3, 3);

        System.out.println("Change bugger2 nick");
        bugger2.setNickName("bigBug");

        System.out.println("We can't get the value by key, since key HashCode() differs. Extracted value for bugger2 is: "
                + myHashMap.get(bugger2));

        System.out.println("HashMap keys: " + myHashMap.keySet());

    }
}
