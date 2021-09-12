package homework_7.kitten_to_cat;

@FunctionalInterface
public interface CatToKittenFunction <T extends Kitten, U extends Cat> {

    U grow(T t);

}
