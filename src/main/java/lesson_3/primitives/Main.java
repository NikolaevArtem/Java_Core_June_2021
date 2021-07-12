package lesson_3.primitives;

public class Main {

  private static boolean bl;
  private static byte bt;
  private static short sh;
  private static int in;
  private static long lo;
  private static float fl;
  private static double dbl;
  private static char ch1;

  public static void defaultValues() {
    System.out.println(bl);
    System.out.println(bt);
    System.out.println(sh);
    System.out.println(in);
    System.out.println(lo);
    System.out.println(fl);
    System.out.println(dbl);
    System.out.println(ch1);
  }

  public static void waysOfInit() {
    float f = 1_000.000_000f, c = 1223; // not recommended
    int i;
    i = 5; // not recommended
    long lo = 5567L; // good
  }

  public static void main(String[] args) {
//    https://javarush.ru/groups/posts/630-primitivnihe-tipih-v-java--ne-takie-uzh-oni-i-primitivnihe
    defaultValues();

    // Булеан
    boolean b = false;

    // Целочисленные
    byte by = 123; //8
    short sh = 12345; //16
    int i2 = 1234567890; //32
    long l1 = 1234567890_123456789L; //64, 0l не ошибка, но плохо читается

    // С плавающей точкой
    float f = 12345.1234512345f; //32
    double dl = 1234.1234; //64
//    System.out.println((int) i1);

    // Char
    char ch2 = '1'; // '12' invalid
    char ch3 = 42711;
//    System.out.println(ch3);
//    charOperations();

    // переполнение целочисленного значения приводит к противоположному наибольшему/наименьшему значению
    //    byte b5 = 127;
//    b5++;
//    System.out.println(b5); // -128
  }

  public static void charOperations() {
    char a = 100;
    char b = 52;                    // Output
    System.out.println( b );        // 4
    System.out.println( a - b );    // 48
    char c = (char)(a - b);
    System.out.println( c );        // 0
    System.out.println( b - a );    // -48
    char d1 = (char)(b - a);
    System.out.println( d1 );        // ￐
  }

}
