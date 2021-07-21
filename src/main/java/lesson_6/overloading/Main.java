package lesson_6.overloading;

public class Main {

  public static void main(String[] args) {
//    Animal animalButCat = new Cat();
//    new Main().printLine(animalButCat);

    new Main().printLine(5, "s", "ss", "sss", "ssss");
  }

  private void printLine() {
    System.out.println("Line");
  }

  private void printLine(String s) {
    System.out.println(s);
  }

  private String printLine(String s, String append) {
    System.out.println(s + append);
    return s;
  }

//  private String printLine(String prepend,String s) {
//    System.out.println(prepend + s);
//    return s;
//  }

  private void printLine(Integer in) {
    System.out.println(in);
  }

  private static void printLine(Integer in, String s) {
    System.out.println(in + s);
  }

  private void printLine(String s, Integer in) {
  }

  private void printLine(Cat cat) {
    System.out.println("Cat!");
  }

  private void printLine(Animal animal) {
    System.out.println("Animal!");
  }

  private void printLine(Integer in, String... strings) {
    for (String s: strings) {
      System.out.println(s + in);
    }

  }

}
