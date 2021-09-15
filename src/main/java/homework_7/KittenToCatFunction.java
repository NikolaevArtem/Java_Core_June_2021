package homework_7;

@FunctionalInterface
public interface KittenToCatFunction<Kitten> {
     Cat grow(Kitten kitten);
}
