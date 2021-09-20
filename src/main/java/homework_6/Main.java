package homework_6;

import homework_6.map_problems.MapProblemsCollisionGenerator;
import homework_6.map_problems.MapProblemsMutableGenerator;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


//сделано в срок, писал в личку
public class Main {

    public static void main(String[] args) {

        new Main().runMapProblemsMutable();
        new Main().runMapProblemsCollision();

    }

    private void runMapProblemsMutable() {
        MapProblemsMutableGenerator val = new MapProblemsMutableGenerator("Cat", 1, new Color(183, 86, 192));
        Map<MapProblemsMutableGenerator, Integer> map = new HashMap<>();
        map.put(val, 123);
        val.setClazzAge(21);
        System.out.println("map.containsKey(val) = " + map.containsKey(val));
    }

    private void runMapProblemsCollision() {
        MapProblemsCollisionGenerator val1 = new MapProblemsCollisionGenerator("Cat", 1, new Color(183, 86, 192));
        MapProblemsCollisionGenerator val2 = new MapProblemsCollisionGenerator("Dog", 2, new Color(197, 193, 78));
        Map<MapProblemsCollisionGenerator, String> map = new HashMap<>();

        map.put(val1, "Murzik");
        map.put(val2, "Sharik");

        System.out.println("map = " + map);
        System.out.println("map.get(val1) = " + map.get(val1));
        System.out.println("map.get(val2) = " + map.get(val2));
    }


}
