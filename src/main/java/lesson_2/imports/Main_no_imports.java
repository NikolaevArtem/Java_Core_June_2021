package lesson_2.imports;

public class Main_no_imports {

  public static void main(String[] args) {
    final lesson_2.imports.models.Human human = new lesson_2.imports.models.Human();
    human.talks();
    human.staticTalk();
    lesson_2.imports.models.Human.staticTalk();

    final lesson_2.imports.models.Animal animal = new lesson_2.imports.models.Animal();
    animal.walk();
    animal.staticWalk();
    lesson_2.imports.models.Animal.staticWalk();
  }

}
