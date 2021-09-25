package homework_7.kitten_to_cat_function;

@FunctionalInterface
interface KittenToCatFunction <Kitten, Cat> {
    Cat grow(Kitten kitten);
}
