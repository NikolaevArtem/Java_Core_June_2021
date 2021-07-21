package lesson_6.lombok;

public class Main {

  public static void main(String[] args) {
    final Cat cat = new Cat("432", 1);
    final Cat cat1 = new Cat("dad");
    final Cat cat2 = new Cat();
    System.out.println(cat.equals(cat1));
    System.out.println(cat.toString());
    System.out.println(cat.hashCode());
  }

}
