package homework_7;

@FunctionalInterface
public interface KittenToCatFunction<K extends Kitten> {
     Cat grow(K k);
}
