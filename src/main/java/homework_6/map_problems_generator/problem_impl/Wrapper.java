package homework_6.map_problems_generator.problem_impl;

import homework_6.map_problems_generator.Problem;

import java.util.ArrayList;
import java.util.List;

public class Wrapper <T> implements Problem<T> {
    private final Problem<T> innerProblem;
    private final List<String> event = new ArrayList<>();

    public Wrapper(Problem<T> innerProblem) {
        this.innerProblem = innerProblem;
    }

    public List<String> getEvent() {
        return event;
    }

    private void update(String str, String result) {
        String res = "At the object class(" + innerProblem.getClass().getSimpleName() +
                ") with value = " + innerProblem.getValue() +
                ", was called method " + str +
                ". Result = " + result;
        event.add(res);
    }

    @Override
    public T getValue() {
        return innerProblem.getValue();
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = innerProblem.equals(o);
        update("equals".toUpperCase() ,String.valueOf(equals));
        return equals;
    }

    @Override
    public int hashCode() {
        int hashCode = innerProblem.hashCode();
        update("hashCode".toUpperCase() ,String.valueOf(hashCode));
        return hashCode;
    }
}
