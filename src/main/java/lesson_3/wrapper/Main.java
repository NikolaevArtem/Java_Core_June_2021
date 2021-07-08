package lesson_3.wrapper;

public class Main {

  public static void main(String[] args) {
    Boolean b;
    Byte bt;
    Short sh;
    Integer in;
    Long l;
    Float f;
    Double d;
    Character ch;

    // Wrappers are immutable, every change -> new object
    Integer i4 = new Integer("5");
    System.out.println(i4);
    i4 = i4 + 5;
  }

  public static void cachedValuesInWrappers() {
    Integer i1 = 10;
    Integer l1 = 10;
    System.out.println(i1 == l1); //true

    Integer i2 = 128;
    Integer l2 = 128;
    System.out.println(i1 == l1); // false, out of cache
  }

}
