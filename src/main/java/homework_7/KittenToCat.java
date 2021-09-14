package homework_7;
@FunctionalInterface
public interface KittenToCat<C extends Cat, K extends Kitten> {
    Cat trasfom(Kitten kitten);
}
