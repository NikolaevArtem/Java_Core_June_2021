package homework_6;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        MapProblemsMutableGenerator problem = new MapProblemsMutableGenerator("first");
        MapProblemsMutableGenerator problem2 = new MapProblemsMutableGenerator("second");
        HashMap<String, Integer> map = new HashMap();
        map.put(problem.getName(), 1);
        map.put(problem2.getName(), 2);
        System.out.println(map.get(problem.getName()));

    }
}
