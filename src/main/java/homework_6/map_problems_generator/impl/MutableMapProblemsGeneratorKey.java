package homework_6.map_problems_generator.impl;

import java.util.Random;

public class MutableMapProblemsGeneratorKey<T> extends AbstractMapProblemsGenerator<T> {

    public MutableMapProblemsGeneratorKey() {
        super(null);
    }

    public MutableMapProblemsGeneratorKey(T value) {
        super(value);
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }
}