package lesson_5.immutable_class;

public class Main {

  public static String copyOfs;

  public static void main(String[] args) {
    String immutableString = "Hello!";
    saveLink(immutableString);
    immutableString = immutableString + " goodbye";
    System.out.println("Immutable string: " + immutableString);
    System.out.println("Copy of it: " + copyOfs);
  }

  private static void saveLink(String s) {
    copyOfs = s;
  }

}
