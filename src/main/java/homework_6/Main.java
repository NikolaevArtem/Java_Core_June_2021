package homework_6;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<MapProblemsCollisionGenerator, String> map = new HashMap();
        MapProblemsMutableGenerator mutableProblemGenerator = new MapProblemsMutableGenerator(0);

        map.put(mutableProblemGenerator, "Some very important information");
        System.out.println(map.get(mutableProblemGenerator));
        mutableProblemGenerator.setSomeNumber(2);
        System.out.println(map.get(mutableProblemGenerator)); //got some problem

    }
}
