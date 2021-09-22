package homework_6.map_problems_generator;

import homework_6.map_problems_generator.problem_impl.MutableProblem;
import homework_6.map_problems_generator.problem_impl.Wrapper;

import java.io.UncheckedIOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MapProblemsGenerator<String> generator = new MapProblemsGenerator<>();
        Map<Problem<String>, Integer> problemIntegerHashMap = new HashMap<>();

        Wrapper<String> noProblem = new Wrapper<>(generator.generateNoProblemClass("first"));
        Wrapper<String> collisionProblem = new Wrapper<>(generator.generateCollisionProblemClass("second"));
        Wrapper<String> collisionProblem2 = new Wrapper<>(generator.generateCollisionProblemClass("third"));
        Wrapper<String> gettingProblem = new Wrapper<>(generator.generateGettingProblemClass("fourth"));

        MutableProblem<String> muttable = generator.generateMutableProblemClass("Muttable");
        Wrapper<String> mutableProblem = new Wrapper<>(muttable);

        problemIntegerHashMap.put(noProblem, 1);

        problemIntegerHashMap.put(collisionProblem, 1);
        problemIntegerHashMap.put(collisionProblem2, 1);

        problemIntegerHashMap.put(gettingProblem, 1);
        problemIntegerHashMap.get(gettingProblem);

        problemIntegerHashMap.put(mutableProblem, 1);
        System.out.println(problemIntegerHashMap.get(mutableProblem));
        muttable.setValue("Mod " + muttable.getValue());
        System.out.println(problemIntegerHashMap.get(mutableProblem));

        problemIntegerHashMap.keySet().forEach(o -> ((Wrapper<String>)o).getEvent().forEach(System.out::println));


    }
}
