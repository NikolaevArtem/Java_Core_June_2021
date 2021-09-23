package homework_7.kitten_to_cat_function;

@FunctionalInterface
public interface KittenToCatFunction <K extends Kitten,C extends Cat> {
    C grow(K kitten);
}
