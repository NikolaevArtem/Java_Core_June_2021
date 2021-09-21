package homework_7;

import homework_7.entity.Cat;
import homework_7.entity.Kitten;

@FunctionalInterface
public interface KittenToCatFunction<K extends Kitten, C extends Cat> {
    C grow(K kitten);
}
