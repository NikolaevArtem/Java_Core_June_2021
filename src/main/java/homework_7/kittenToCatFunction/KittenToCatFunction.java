package homework_7.kittenToCatFunction;

@FunctionalInterface
public interface KittenToCatFunction<C extends Cat, K extends Kitten>{
    Cat grow(Kitten k);
}
