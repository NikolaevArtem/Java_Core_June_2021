package homework_7.function;

import homework_7.model.cat_model.Cat;
import homework_7.model.kitten_model.Kitten;

@FunctionalInterface
public interface KittenToCatFunction <C extends Cat, K extends Kitten> {

    C grow(K kitten);

}
