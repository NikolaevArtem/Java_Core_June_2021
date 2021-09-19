package homework_7;

@FunctionalInterface
public interface KittenToCatFunction <C extends Cat, T extends Kitten> {

    C grow(T object);
}
