package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsMutableGenerator, String> container_mutable_gen = new HashMap<>();

        MapProblemsMutableGenerator generator_one = new MapProblemsMutableGenerator(new StringBuilder("one"));
        MapProblemsMutableGenerator generator_two = new MapProblemsMutableGenerator(new StringBuilder("two"));
        container_mutable_gen.put(generator_one, "one");
        container_mutable_gen.put(generator_two, "two");

        String resultTwo_valid = container_mutable_gen.get(generator_two);

        System.out.println("resultTwo_valid = " + resultTwo_valid);

        generator_two.setKey(new StringBuilder("collision"));

        String resultTwo_invalid = container_mutable_gen.get(generator_two);

        System.out.println("resultTwo_invalid = " + resultTwo_invalid);


        HashMap<MapProblemsCollisionGenerator, String> container_problems_coll_gen = new HashMap<>();

        MapProblemsCollisionGenerator one_collision_gen = new MapProblemsCollisionGenerator(new StringBuilder("one"));
        MapProblemsCollisionGenerator two_collision_gen = new MapProblemsCollisionGenerator(new StringBuilder("two"));
        MapProblemsCollisionGenerator three_collision_gen = new MapProblemsCollisionGenerator(new StringBuilder("three"));


        container_problems_coll_gen.put(one_collision_gen, "one");
        container_problems_coll_gen.put(two_collision_gen, "two");
        container_problems_coll_gen.put(three_collision_gen, "three");

        System.out.println("Count of collision in one_collision_gen = " + one_collision_gen.getCountCollision());
        System.out.println("Count of collision in two_collision_gen = " + two_collision_gen.getCountCollision());
        System.out.println("Count of collision in three_collision_gen = " + three_collision_gen.getCountCollision());
    }

}
