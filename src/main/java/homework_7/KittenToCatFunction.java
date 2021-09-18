package homework_7;

import homework_7.util.Cat;
import homework_7.util.Kitten;

@FunctionalInterface
public interface KittenToCatFunction <R extends Cat, T extends Kitten> {

    R grow(T obj);
}
