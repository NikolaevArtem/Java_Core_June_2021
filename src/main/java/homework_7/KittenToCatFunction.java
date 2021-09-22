package homework_7;

@FunctionalInterface
public interface KittenToCatFunction <C extends Cat, K extends Kitten> {
    C grow(K kitten);
}
