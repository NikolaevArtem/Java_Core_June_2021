package homework_7.kitten_to_cat_function;

@FunctionalInterface
public interface KittenToCatFunction<T extends Cat, R extends Kitten> {
    T grow(R o);
}
