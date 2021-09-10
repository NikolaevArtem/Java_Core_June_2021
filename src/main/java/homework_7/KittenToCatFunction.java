package homework_7;

@FunctionalInterface
interface KittenToCatFunction <Kitten, Cat> {
    Cat grow(Kitten kitten);
}
