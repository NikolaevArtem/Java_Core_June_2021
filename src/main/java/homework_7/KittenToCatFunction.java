package homework_7;

import homework_7.animals.Cat;
import homework_7.animals.Kitten;

@FunctionalInterface
public interface KittenToCatFunction <T extends Kitten, R extends Cat>{

    R grow(T t);
}
