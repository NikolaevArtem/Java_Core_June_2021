package homework_6;

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
        System.out.println("MapProblemsMutable");

        Map<MapProblemsMutableGenerator, Integer> map = new HashMap<>();

        MapProblemsMutableGenerator o1 = new MapProblemsMutableGenerator("First obj", 1, new Color(183, 86, 192));
        MapProblemsMutableGenerator o2 = new MapProblemsMutableGenerator("Second obj", 2, new Color(197, 193, 78));
        MapProblemsMutableGenerator o3 = new MapProblemsMutableGenerator("Third obj", 3, new Color(73, 113, 166));
        MapProblemsMutableGenerator on = new MapProblemsMutableGenerator("Nth obj", Integer.MAX_VALUE, new Color(61, 199, 176));

        MapProblemsMutableGenerator o1Clone = new MapProblemsMutableGenerator("First obj", 1, new Color(183, 86, 192));

        System.out.println("\no1 equals with all objects");
        System.out.println("o1.equals(o2) = " + o1.equals(o2));
        System.out.println("o1.equals(o3) = " + o1.equals(o3));
        System.out.println("o1.equals(on) = " + o1.equals(on));

        System.out.println("\no2 equals with all objects");
        System.out.println("o2.equals(o1) = " + o2.equals(o1));
        System.out.println("o2.equals(o3) = " + o2.equals(o3));
        System.out.println("o2.equals(on) = " + o2.equals(on));

        System.out.println("\no3 equals with all objects");
        System.out.println("o3.equals(o1) = " + o3.equals(o1));
        System.out.println("o3.equals(o2) = " + o3.equals(o2));
        System.out.println("o3.equals(on) = " + o3.equals(on));

        System.out.println("\non equals with all objects");
        System.out.println("on.equals(o1) = " + on.equals(o1));
        System.out.println("on.equals(o2) = " + on.equals(o2));
        System.out.println("on.equals(o3) = " + on.equals(o3));

        map.put(o1, 2);
        map.put(o2, 1);
        map.put(o3, 1);
        map.put(on, 1);


        System.out.println("\ntry find o1");
        Integer temp;
        int count = 0;
        do {
            temp = map.get(o1);
            count++;
        } while (temp == null);
        System.out.println("count = " + count + ", temp = " + temp);
        System.out.println("(o1.getClazzAge() == temp) = " + (o1.getClazzAge() == temp));

        System.out.println("\no1 equals with o1Clone");
        System.out.println("o1.equals(o1Clone) = " + o1.equals(o1Clone));
    }

    private void runMapProblemsCollision() {
    }


}
