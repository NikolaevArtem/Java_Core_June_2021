package lesson_8.cloneable;

public class Main {

  public static void main(String[] args) throws CloneNotSupportedException {

    final Cat cat1 = new Cat("Murzik", new Breed("british"));
    final Cat cat2 = cat1.clone();
    System.out.println("cat1 = " + cat1);
    System.out.println("cat2 = " + cat2);

    cat1.getBreed().setBreedName("mainkun");

    System.out.println("cat1 = " + cat1);
    System.out.println("cat2 = " + cat2);
  }

}
