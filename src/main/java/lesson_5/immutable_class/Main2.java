package lesson_5.immutable_class;

public class Main2 {

  public static Cat copyOfCat;

  public static void main(String[] args) {
    final Cat cat = new Cat();
    saveLink(cat);
    cat.integer = cat.integer + 5;

    System.out.println("Mutable Cat: " + cat.integer);
    System.out.println("Copy of it: " + copyOfCat.integer);
  }

  private static void saveLink(Cat in) {
    copyOfCat = in;
  }

}
