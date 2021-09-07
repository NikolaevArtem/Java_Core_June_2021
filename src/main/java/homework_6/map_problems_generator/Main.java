package homework_6.map_problems_generator;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsCollisionGenerator, String> map = new HashMap<>();
        MapProblemsCollisionGenerator key11 = new MapProblemsCollisionGenerator(1, "firstProblem");
        MapProblemsCollisionGenerator key12 = new MapProblemsCollisionGenerator(1, "secondProblem");
        MapProblemsCollisionGenerator key13 = new MapProblemsCollisionGenerator(2, "thirdProblem");
        map.put(key11, "firstValue");
        map.put(key12, "secondValue");
        map.put(key13, "thirdValue");
        System.out.println("Illustration of collision:");
        System.out.println("Value of first key is " + map.get(key11) + ", must be firstValue");
        System.out.println("Value of second key is " + map.get(key12) + ", must be secondValue");
        System.out.println("Value of third key is " + map.get(key13) + ", must be thirdValue");

        HashMap<MapProblemsMutableGenerator, String> mutableMap = new HashMap<>();
        MapProblemsMutableGenerator key21 = new MapProblemsMutableGenerator(1, "firstProblem");
        MapProblemsMutableGenerator key22 = new MapProblemsMutableGenerator(1, "secondProblem");
        MapProblemsMutableGenerator key23 = new MapProblemsMutableGenerator(2, "thirdProblem");
        mutableMap.put(key21, "firstValue");
        mutableMap.put(key22, "secondValue");
        mutableMap.put(key23, "thirdValue");
        System.out.println("------------");
        System.out.println("Illustration of using mutable class as a key:");
        System.out.println("Value of second key before changing is " + mutableMap.get(key22));
        key22.setProblemNumber(2);
        System.out.println("Value of second key after changing is " + mutableMap.get(key22));
    }
}
