package homework_7;

import homework_7.pets.Cat;
import homework_7.pets.Kitten;

@FunctionalInterface
public interface KittenToCatFunction <T extends Kitten, R extends Cat>{

    R grow(T t);

}