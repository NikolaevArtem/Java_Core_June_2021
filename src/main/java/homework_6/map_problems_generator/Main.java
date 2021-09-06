package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsCollisionGenerator<String, String>, String> container_problems_coll_gen = new HashMap<>();
        container_problems_coll_gen.put(new MapProblemsCollisionGenerator<>("one", "one"), "one");
        container_problems_coll_gen.put(new MapProblemsCollisionGenerator<>("two", "two"), "two");

        String resultTwo_1 = container_problems_coll_gen.get(new MapProblemsCollisionGenerator<>("two", "two"));



        HashMap<MapProblemsMutableGenerator<String>, String> container_mutable_gen = new HashMap<>();
        container_mutable_gen.put(new MapProblemsMutableGenerator<>("one"), "one");
        container_mutable_gen.put(new MapProblemsMutableGenerator<>("two"), "two");

        String resultTwo_2 = container_mutable_gen.get(new MapProblemsMutableGenerator<>("two"));
    }

}
