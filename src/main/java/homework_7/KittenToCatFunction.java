package homework_7;

@FunctionalInterface
public interface KittenToCatFunction<T extends Kitten,N extends Cat> {
    N grow(T t);
}
